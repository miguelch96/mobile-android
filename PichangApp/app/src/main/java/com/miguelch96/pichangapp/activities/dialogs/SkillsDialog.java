package com.miguelch96.pichangapp.activities.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.models.Equipo;

public class SkillsDialog extends DialogFragment {

    private TextView puntualidadTextView;
    private TextView dificultadTextView;
    private TextView juegolimpioTextView;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_skills_dialog, null);

        Bundle bundle = getArguments();
        Equipo equipo =(Equipo) bundle.getSerializable("equipo");
        puntualidadTextView = (TextView) view.findViewById(R.id.puntualidadTextView);
        dificultadTextView = (TextView) view.findViewById(R.id.dificultadTextView);
        juegolimpioTextView = (TextView) view.findViewById(R.id.juegolimpioTextView);





        builder.setView(view);


        puntualidadTextView.setText("Puntualidad: " + String.valueOf(equipo.getSkills().get(0)));
        dificultadTextView.setText("Dificultad: "+ String.valueOf(equipo.getSkills().get(1)));
        juegolimpioTextView.setText("Juego limpio: " + String.valueOf(equipo.getSkills().get(2)));
        // testTextView.setText(equipo.getNombre());
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout

        // Add action buttons
        AlertDialog alert = builder.create();
        return alert;
    }
}
