package com.miguelch96.pichangapp.activities;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.dialogs.equipo.IntegrantesDialog;
import com.miguelch96.pichangapp.dialogs.equipo.ScoresDialog;
import com.miguelch96.pichangapp.dialogs.equipo.SkillsDialog;
import com.miguelch96.pichangapp.adapters.equipo.PictureAdapter;
import com.miguelch96.pichangapp.fragments.equipo.ElegirCanchaFragment;
import com.miguelch96.pichangapp.models.Equipo;

public class EquipoActivity extends AppCompatActivity {

    private RecyclerView picturesRecyclerView;
    private PictureAdapter picturesAdapter;
    private RecyclerView.LayoutManager picturesLayoutManager;

    ImageButton iconSkills;
    ImageButton iconIntegrantes;
    ImageButton iconScore;
    Button buttonRetar;
    TextView nombreTextView;
    TextView distritoTextView;
    TextView categoriaTextView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_equipo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);




        Bundle bundle = getIntent().getExtras();
        Equipo equipo = (Equipo) bundle.getSerializable("equipo");

        picturesAdapter =new PictureAdapter(equipo.getPictures());

        picturesLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        picturesRecyclerView =(RecyclerView) findViewById(R.id.picturesRecyclerView);
        picturesRecyclerView.setAdapter(picturesAdapter);
        picturesRecyclerView.setLayoutManager(picturesLayoutManager);

        iconIntegrantes = (ImageButton) findViewById(R.id.iconIntegrantes);
        iconScore = (ImageButton) findViewById(R.id.iconScore);
        iconSkills = (ImageButton) findViewById(R.id.iconSkills);
        buttonRetar = (Button) findViewById(R.id.retarButton);
        nombreTextView = (TextView) findViewById(R.id.nombreTextView);
        distritoTextView = (TextView) findViewById(R.id.distritoTextView);
        categoriaTextView = (TextView) findViewById(R.id.categoriaTextView);

        nombreTextView.setText(equipo.getNombre());
        distritoTextView.setText(equipo.getDistrito());
        categoriaTextView.setText(equipo.getCategoria());

        buttonRetar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Elegir cancha
                Bundle bundle = new Bundle();
                ElegirCanchaFragment fragment = new ElegirCanchaFragment();
                fragment.setArguments(bundle);

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content,fragment)
                        .commit();
            }
        });

        iconIntegrantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getExtras();
                DialogFragment dialog = new IntegrantesDialog();

                dialog.setArguments(bundle);
                dialog.show(getFragmentManager(), "IntegrantesDialog");
            }
        });

        iconSkills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getExtras();
                DialogFragment dialog = new SkillsDialog();

                dialog.setArguments(bundle);
                dialog.show(getFragmentManager(), "SkillsDialog");
            }
        });

        iconScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getExtras();
                DialogFragment dialog = new ScoresDialog();

                dialog.setArguments(bundle);
                dialog.show(getFragmentManager(), "ScoresDialog");
            }
        });
    }
}
