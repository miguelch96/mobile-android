package com.miguelch96.pichangapp.dialogs.equipo;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.adapters.equipo.ElegirCanchaAdapter;
import com.miguelch96.pichangapp.models.Cancha;
import com.miguelch96.pichangapp.repositories.CanchaRepository;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElegirCanchaDialog extends DialogFragment {

    private RecyclerView canchasRecyclerView;
    private ElegirCanchaAdapter canchaAdapter;
    private RecyclerView.LayoutManager canchaLayoutManager;
    private ImageView backButton;
    private List<Cancha> canchas;
    public ElegirCanchaDialog() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = super.onCreateView(inflater, container, savedInstanceState);
        getDialog().getWindow().setGravity(Gravity.BOTTOM);
        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_elegir_cancha, null);

        canchas = new ArrayList<>();
        updateData();
        canchaAdapter =new ElegirCanchaAdapter(canchas);

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
    public void updateData() {
        AndroidNetworking.get("http://miguelch96-001-site1.itempurl.com/api/canchas")
                .setPriority(Priority.LOW)
                .setTag(getString(R.string.app_name))
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            canchas = Cancha.from(response.getJSONArray("canchas"));
                            canchaAdapter.setCanchas(canchas);
                            canchaAdapter.notifyDataSetChanged();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(getString(R.string.app_name), anError.getLocalizedMessage());

                    }
                });
    }

}
