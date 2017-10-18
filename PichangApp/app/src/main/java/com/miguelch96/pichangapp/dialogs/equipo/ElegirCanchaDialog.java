package com.miguelch96.pichangapp.dialogs.equipo;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.adapters.equipo.ElegirCanchaAdapter;
import com.miguelch96.pichangapp.repositories.CanchaRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElegirCanchaDialog extends DialogFragment {

    private RecyclerView canchasRecyclerView;
    private ElegirCanchaAdapter canchaAdapter;
    private RecyclerView.LayoutManager canchaLayoutManager;
    private ImageView backButton;

    public ElegirCanchaDialog() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
View view = super.onCreateView(inflater, container, savedInstanceState);
        getDialog().getWindow().setGravity(Gravity.BOTTOM);
       // WindowManager.LayoutParams p = getDialog().getWindow().getAttributes();
       // p.width = ViewGroup.LayoutParams.MATCH_PARENT;

        //p.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE;
        //  p.y = 200;


      //  getDialog().getWindow().setAttributes(p);
        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_elegir_cancha, null);

        canchaAdapter =new ElegirCanchaAdapter(CanchaRepository.getCanchas());

        canchaLayoutManager=new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);

        canchasRecyclerView =view.findViewById(R.id.selectCanchaRecyclerView);
        canchasRecyclerView.setAdapter(canchaAdapter);
        canchasRecyclerView.setLayoutManager(canchaLayoutManager);

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


}
