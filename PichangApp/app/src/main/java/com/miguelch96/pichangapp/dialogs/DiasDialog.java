package com.miguelch96.pichangapp.dialogs;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.miguelch96.pichangapp.R;

/**
 * Created by Sergio on 17/10/2017.
 */

public class DiasDialog extends DialogFragment {

    private String[] dias = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Escoge un día").setItems(dias, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String day = dias[i];
                Bundle bundle = getArguments();
                bundle.putString("dia",day);
                DialogFragment dialog = new HorariosDialog();
                dialog.setArguments(bundle);
                dialog.show(getFragmentManager(), "HorariosDialog");
            }
        })
        .setNegativeButton("Atras", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getDialog().dismiss();
            }
        });

      return builder.create();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        getDialog().getWindow().setGravity(Gravity.BOTTOM);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
