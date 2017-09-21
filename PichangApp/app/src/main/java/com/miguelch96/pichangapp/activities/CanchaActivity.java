package com.miguelch96.pichangapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.models.Cancha;

public class CanchaActivity extends AppCompatActivity {

    ImageView pictureImageView;
    TextView nombreTextView;
    TextView distritoTextView;
    TextView categoriaTextView;
    Button reservarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancha);

        Cancha cancha=Cancha.from(getIntent().getExtras());

        pictureImageView= (ImageView) findViewById(R.id.pictureImageView);
        nombreTextView= (TextView) findViewById(R.id.nombreTextView);
        distritoTextView= (TextView) findViewById(R.id.distritoTextView);
        categoriaTextView= (TextView) findViewById(R.id.categoriaTextView);
        reservarButton= (Button) findViewById(R.id.reservarButton);

        pictureImageView.setImageResource(cancha.getPictureId());
        nombreTextView.setText(cancha.getNombre());
        distritoTextView.setText(cancha.getDistrito());
        categoriaTextView.setText("Categoria Harcodeada");
        reservarButton.setText("/S. "+cancha.getPrecio());

    }
}
