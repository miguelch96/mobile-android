package com.miguelch96.pichangapp.activities.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.adapters.IntegrantesAdapter;
import com.miguelch96.pichangapp.models.Equipo;

public class IntegrantesDialog extends DialogFragment {

   // @Override
    //protected void onCreate(Bundle savedInstanceState) {
      //  super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_integrantes_dialog);
   // }


    private RecyclerView integrantesRecyclerView;
    private IntegrantesAdapter integrantesAdapter;
    private RecyclerView.LayoutManager integrantesLayoutManager;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_integrantes_dialog, null);

        Bundle bundle = getArguments();
        Equipo equipo =(Equipo) bundle.getSerializable("equipo");

        //testTextView = (TextView) view.findViewById(R.id.testTextView);
        integrantesAdapter =new IntegrantesAdapter(equipo.getIntegrantes());

        integrantesLayoutManager=new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);

        integrantesRecyclerView =view.findViewById(R.id.integrantesRecyclerView);
        integrantesRecyclerView.setAdapter(integrantesAdapter);
        integrantesRecyclerView.setLayoutManager(integrantesLayoutManager);


        builder.setView(view);




       // testTextView.setText(equipo.getNombre());
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout

                // Add action buttons
        AlertDialog alert = builder.create();
        return alert;
    }

}
