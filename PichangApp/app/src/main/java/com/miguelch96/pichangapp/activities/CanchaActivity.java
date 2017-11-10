package com.miguelch96.pichangapp.activities;

import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.adapters.equipo.PictureAdapter;
import com.miguelch96.pichangapp.adapters.equipo.SkillAdapter;
import com.miguelch96.pichangapp.dialogs.DiasDialog;
import com.miguelch96.pichangapp.dialogs.ScoresDialog;
import com.miguelch96.pichangapp.dialogs.cancha.InfoDialog;
import com.miguelch96.pichangapp.models.Cancha;

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

        nombreTextView = (TextView) findViewById(R.id.nombreTextView);
        distritoTextView = (TextView) findViewById(R.id.distritoTextView);
        materialTextView = (TextView) findViewById(R.id.materialTextView);
        buttonReservar = (Button) findViewById(R.id.reservarButton);
        precioTextView = (TextView) findViewById(R.id.precioTextView);
        iconInfo = (ImageButton) findViewById(R.id.iconInfo);
        iconMap = (ImageButton) findViewById(R.id.iconMap);
        iconScore = (ImageButton) findViewById(R.id.iconScore);

        picturesAdapter =new PictureAdapter(cancha.getPictures());

        picturesLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        picturesRecyclerView =(RecyclerView) findViewById(R.id.picturesRecyclerView);
        picturesRecyclerView.setAdapter(picturesAdapter);
        picturesRecyclerView.setLayoutManager(picturesLayoutManager);

        skillsAdapter =new SkillAdapter(cancha.getServicios());

        skillsLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        skillsRecyclerView =(RecyclerView) findViewById(R.id.skillsRecyclerView);
        skillsRecyclerView.setAdapter(skillsAdapter);
        skillsRecyclerView.setLayoutManager(skillsLayoutManager);

        nombreTextView.setText(cancha.getNombre());
        distritoTextView.setText(cancha.getDistrito());
        materialTextView.setText(cancha.getMaterial());
        precioTextView.setText("Precio: " + String.valueOf(cancha.getPrecio()));


        buttonReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = getIntent().getExtras();
                DiasDialog dialog = new DiasDialog();
                bundle.putString("object", "cancha");
                dialog.setArguments(bundle);

                dialog.show(getFragmentManager(), "DiasDialog");
            }
        });

        iconScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getExtras();
                bundle.putString("object", "cancha");
                DialogFragment dialog = new ScoresDialog();
                dialog.setArguments(bundle);
                dialog.show(getFragmentManager(), "ScoresDialog");
            }
        });

        iconInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getExtras();
                DialogFragment dialog = new InfoDialog();
                dialog.setArguments(bundle);
                dialog.show(getFragmentManager(), "InfoDialog");
            }
        });
        iconMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+cancha.getDireccion()+" "+cancha.getDistrito());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
