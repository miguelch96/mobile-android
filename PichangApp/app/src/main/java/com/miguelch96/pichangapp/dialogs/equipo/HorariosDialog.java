package com.miguelch96.pichangapp.dialogs.equipo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.miguelch96.pichangapp.R;

/**
 * Created by Sergio on 17/10/2017.
 */

public class HorariosDialog extends DialogFragment {

    private ListView listHorarios;
    private ImageView backButton;
    private String[] horarios = {"3pm","4pm","5pm", "6pm", "7pm", "8pm", "9pm", "10pm"};


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_horarios, null);

        listHorarios = (ListView)view.findViewById(R.id.listviewHorarios);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, horarios);

        listHorarios.setAdapter(adaptador);

        listHorarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = (String)adapterView.getItemAtPosition(i);

                Bundle bundle = getArguments();
                DialogFragment dialog = new ConfirmacionDialog();

                dialog.setArguments(bundle);
                dialog.show(getFragmentManager(), "ConfirmacionDialog");
            }
        });

        backButton = view.findViewById(R.id.backImageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        builder.setView(view);
        AlertDialog alert = builder.create();
        return alert;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        getDialog().getWindow().setGravity(Gravity.BOTTOM);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
