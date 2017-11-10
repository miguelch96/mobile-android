package com.miguelch96.pichangapp.dialogs.cancha;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.miguelch96.pichangapp.activities.MainActivity;

/**
 * Created by Sergio on 09/11/2017.
 */

public class ReservaTerminadaDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("|Reserva realizada con exito!")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent itemIntent = new Intent(getDialog().getContext(), MainActivity.class);
                        getDialog().getContext().startActivity(itemIntent);
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}