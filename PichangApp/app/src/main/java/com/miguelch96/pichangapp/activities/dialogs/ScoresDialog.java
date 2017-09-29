package com.miguelch96.pichangapp.activities.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.models.Equipo;

import org.w3c.dom.Text;

public class ScoresDialog extends DialogFragment {

    private LinearLayout scoreListView;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_scores_dialog, null);

        Bundle bundle = getArguments();
        Equipo equipo =(Equipo) bundle.getSerializable("equipo");
        scoreListView = (LinearLayout) view.findViewById(R.id.scoreListView);

        for (int i =0; i<equipo.getComentarios().size(); i++)
        {
            TextView value=new TextView(view.getContext());
            value.setText(equipo.getComentarios().get(i));
            value.setPadding(5,5,5,5);
            scoreListView.addView(value);
        }


        builder.setView(view);



        // testTextView.setText(equipo.getNombre());
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout

        // Add action buttons
        AlertDialog alert = builder.create();
        return alert;
    }
}
