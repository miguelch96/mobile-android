package com.miguelch96.pichangapp.activities;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;
import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.adapters.equipo.PictureAdapter;
import com.miguelch96.pichangapp.adapters.equipo.SkillAdapter;
import com.miguelch96.pichangapp.dialogs.equipo.DiasDialog;
import com.miguelch96.pichangapp.dialogs.equipo.ElegirCanchaDialog;
import com.miguelch96.pichangapp.dialogs.equipo.ScoresDialog;
import com.miguelch96.pichangapp.models.Cancha;

import java.util.List;

public class CanchaActivity extends AppCompatActivity {

    private RecyclerView picturesRecyclerView;
    private PictureAdapter picturesAdapter;
    private RecyclerView.LayoutManager picturesLayoutManager;

    private RecyclerView skillsRecyclerView;
    private SkillAdapter skillsAdapter;
    private RecyclerView.LayoutManager skillsLayoutManager;

    ImageButton iconInfo;
    ImageButton iconMap;
    ImageButton iconScore;
    Button buttonReservar;
    TextView nombreTextView;
    TextView distritoTextView;
    TextView materialTextView;
    TextView precioTextView;
    ANImageView pictureImageView;
    Menu menu;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu);
        this.menu = menu;
        Bundle bundle = getIntent().getExtras();
        Cancha equipo = (Cancha) bundle.getSerializable("cancha");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Bundle bundle = getIntent().getExtras();
        Cancha equipo = (Cancha) bundle.getSerializable("cancha");

        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancha);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Bundle bundle = getIntent().getExtras();
        final Cancha cancha = (Cancha) bundle.getSerializable("cancha");

        pictureImageView = (ANImageView) findViewById(R.id.pictureImageView);
        nombreTextView = (TextView) findViewById(R.id.nombreTextView);
        distritoTextView = (TextView) findViewById(R.id.distritoTextView);
        materialTextView = (TextView) findViewById(R.id.materialTextView);
        buttonReservar = (Button) findViewById(R.id.reservarButton);
        precioTextView = (TextView) findViewById(R.id.precioTextView);
        iconInfo = (ImageButton) findViewById(R.id.iconInfo);
        iconMap = (ImageButton) findViewById(R.id.iconMap);
        iconScore = (ImageButton) findViewById(R.id.iconScore);

        pictureImageView.setImageUrl(cancha.getPictureUrl());
        pictureImageView.setDefaultImageResId(R.mipmap.ic_launcher);
        pictureImageView.setErrorImageResId(R.mipmap.ic_launcher);
        nombreTextView.setText(cancha.getNombre());
        distritoTextView.setText(cancha.getDistrito());
        materialTextView.setText(cancha.getMaterial());
        precioTextView.setText("Precio: " + "60/" + "120");


        buttonReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Elegir cancha
                Bundle bundle = new Bundle();
                DiasDialog dialog = new DiasDialog();
                dialog.setArguments(bundle);

                dialog.show(getFragmentManager(), "DiasDialog");
            }
        });

        iconScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getExtras();
                bundle.putString("object", "equipo");
                DialogFragment dialog = new ScoresDialog();
                dialog.setArguments(bundle);
                dialog.show(getFragmentManager(), "ScoresDialog");
            }
        });
    }
}
