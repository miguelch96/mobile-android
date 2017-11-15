package com.miguelch96.pichangapp.dialogs.equipo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.dialogs.MessageDialog;

/**
 * Created by Sergio on 17/10/2017.
 */

public class ConfirmacionDialog extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String text = "Estás por retar al equipo: Peloteros FC, para el día : 10/10/17, el pago se va a dividir entre los dos, confirma la invitación por favor.";

        builder.setTitle("Espera...")
                .setMessage(text)

                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DialogFragment dialog = new MessageDialog();
                String message = "Tu invitación ha sido realizada con éxito, ahora espera una respuesta.";
                Bundle bundle = new Bundle();
                bundle.putString("message", message);
                bundle.putString("title", "¡En hora buena!");
                dialog.setArguments(bundle);
                dialog.show(getFragmentManager(), "MessageDialog");
            }
        })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getDialog().dismiss();
            }
        });

        return  builder.create();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().setGravity(Gravity.BOTTOM);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
