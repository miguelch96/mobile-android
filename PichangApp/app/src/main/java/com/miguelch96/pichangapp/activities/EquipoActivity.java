package com.miguelch96.pichangapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.adapters.PictureAdapter;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo);
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
    }
}
