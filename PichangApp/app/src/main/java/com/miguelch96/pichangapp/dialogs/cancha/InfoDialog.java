package com.miguelch96.pichangapp.dialogs.cancha;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.models.Cancha;

public class InfoDialog extends DialogFragment {

    private ImageView backButton;
    private TextView infoTextView;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_info, null);
        Bundle bundle = getArguments();
        Cancha cancha =(Cancha) bundle.getSerializable("cancha");


        backButton = view.findViewById(R.id.backImageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        infoTextView=view.findViewById(R.id.infoTextView);
        infoTextView.setText(cancha.getDescripcion());

        builder.setView(view);
        AlertDialog alert = builder.create();
        return alert;
    }

}
