package com.miguelch96.pichangapp.activities;

import android.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.adapters.SkillAdapter;
import com.miguelch96.pichangapp.dialogs.cancha.InfoDialog;
import com.miguelch96.pichangapp.dialogs.equipo.IntegrantesDialog;
import com.miguelch96.pichangapp.dialogs.ScoresDialog;
import com.miguelch96.pichangapp.adapters.PictureAdapter;
import com.miguelch96.pichangapp.dialogs.equipo.ElegirCanchaDialog;
import com.miguelch96.pichangapp.models.Equipo;
import com.miguelch96.pichangapp.models.Favorite;

import java.util.List;

public class EquipoActivity extends AppCompatActivity {

    private RecyclerView picturesRecyclerView;
    private PictureAdapter picturesAdapter;
    private RecyclerView.LayoutManager picturesLayoutManager;

    private RecyclerView skillsRecyclerView;
    private SkillAdapter skillsAdapter;
    private RecyclerView.LayoutManager skillsLayoutManager;

    ImageButton iconIntegrantes;
    ImageButton iconScore;
    Button buttonRetar;
    TextView nombreTextView;
    TextView distritoTextView;
    TextView categoriaTextView;
    Menu menu;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu);
        this.menu = menu;
        Bundle bundle = getIntent().getExtras();
        Equipo equipo = (Equipo) bundle.getSerializable("equipo");

        if(!Favorite.find(Favorite.class,"equipo_id = ?",String.valueOf(equipo.getEquipoId())).isEmpty()){
            menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_orange_48dp));
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Bundle bundle = getIntent().getExtras();
        Equipo equipo = (Equipo) bundle.getSerializable("equipo");


        switch (item.getItemId()) {
            case R.id.action_favorite:

                DialogFragment dialog = new InfoDialog();

                if(Favorite.find(Favorite.class,"equipo_id = ?",String.valueOf(equipo.getEquipoId())).isEmpty()){
                    Favorite f = new Favorite(equipo.getEquipoId());
                    f.save();
                    menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_orange_48dp));
                    bundle.putString("message", "Equipo agregado a favoritos.");
                    dialog.setArguments(bundle);
                    dialog.show(getFragmentManager(), "InfoDialog");
                }
                else {
                   Favorite f =Favorite.find(Favorite.class,"equipo_id = ?",String.valueOf(equipo.getEquipoId())).get(0);
                    menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white_48dp));
                    f.delete();
                    bundle.putString("message", "Equipo eliminado de favoritos.");
                    dialog.setArguments(bundle);
                    dialog.show(getFragmentManager(), "InfoDialog");
                }
            default:
                return super.onOptionsItemSelected(item);
        }
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

        skillsAdapter =new SkillAdapter(equipo.getSkills());

        skillsLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        skillsRecyclerView =(RecyclerView) findViewById(R.id.skillsRecyclerView);
        skillsRecyclerView.setAdapter(skillsAdapter);
        skillsRecyclerView.setLayoutManager(skillsLayoutManager);


        iconIntegrantes = (ImageButton) findViewById(R.id.iconIntegrantes);
        iconScore = (ImageButton) findViewById(R.id.iconScore);
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
                Bundle bundle = getIntent().getExtras();
                ElegirCanchaDialog dialog = new ElegirCanchaDialog();
                bundle.putString("object", "equipo");
                dialog.setArguments(bundle);

                dialog.show(getFragmentManager(), "ElegirCanchaDialog");
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
