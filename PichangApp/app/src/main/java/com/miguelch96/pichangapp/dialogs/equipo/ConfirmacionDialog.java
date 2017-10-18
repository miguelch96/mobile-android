package com.miguelch96.pichangapp.dialogs.equipo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.miguelch96.pichangapp.R;

/**
 * Created by Sergio on 17/10/2017.
 */

public class ConfirmacionDialog extends DialogFragment {

private Button buttonAceptar;
    private Button buttonCancelar;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_confirmacion, null);

        buttonAceptar =(Button) view.findViewById(R.id.buttonAceptar);
        buttonCancelar =(Button) view.findViewById(R.id.buttomCancelar);

        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialog = new RetoEnviadoDialog();
                dialog.show(getFragmentManager(), "RetoEnviadoDialog");
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
