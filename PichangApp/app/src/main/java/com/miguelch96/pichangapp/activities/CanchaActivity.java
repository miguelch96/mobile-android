package com.miguelch96.pichangapp.activities;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
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
        reservarButton.setText("S/. "+cancha.getPrecio());

        reservarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
                final View mview=getLayoutInflater().inflate(R.layout.dialog_escogerfecha,null);
                CalendarView fechareservaCalendarView=mview.findViewById(R.id.fechareservaCalendarView);





                builder.setView(mview);
                final AlertDialog dialog=builder.create();
                dialog.show();


                fechareservaCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                        AlertDialog.Builder builder2=new AlertDialog.Builder(calendarView.getContext());
                        View view2=getLayoutInflater().inflate(R.layout.dialog_escogerhora,null);
                        dialog.cancel();
                        builder2.setView(view2);
                        AlertDialog dialog2=builder2.create();
                        dialog2.show();
                    }
                });
            }
        });



    }
}
