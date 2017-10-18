package com.miguelch96.pichangapp.dialogs.equipo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.activities.MainActivity;

/**
 * Created by Sergio on 17/10/2017.
 */

public class RetoEnviadoDialog extends DialogFragment {

    private Button okButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().setGravity(Gravity.BOTTOM);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_reto_enviado, null);

        okButton = view.findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getDialog().dismiss();
                Intent itemIntent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(itemIntent);
            }
        });

        builder.setView(view);
        AlertDialog alert = builder.create();
        return alert;

    }
}
