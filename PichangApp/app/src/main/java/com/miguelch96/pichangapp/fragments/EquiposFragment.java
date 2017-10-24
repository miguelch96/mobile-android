package com.miguelch96.pichangapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.adapters.equipo.EquipoAdapter;
import com.miguelch96.pichangapp.models.Equipo;
import com.miguelch96.pichangapp.repositories.EquipoRepository;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EquiposFragment extends Fragment {


    private List<Equipo> equipos;
    private RecyclerView equiposRecyclerView;
    private RecyclerView equipos1RecyclerView;
    private RecyclerView equipos2RecyclerView;
    private EquipoAdapter equipoAdapter;
    private RecyclerView.LayoutManager equiposLayoutManager;

    public EquiposFragment() {
        // Required empty public constructor
    }

    private void updateData() {
        AndroidNetworking.get("http://pichangappservice.azurewebsites.net/api/equipos")
                .setPriority(Priority.LOW)
                .setTag(getString(R.string.app_name))
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            equipos = Equipo.from(response.getJSONArray("equipos"));
                            equipoAdapter.setEquipos(equipos);
                            equipoAdapter.notifyDataSetChanged();


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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_equipos,container,false);
        equipos=new ArrayList<>();
        updateData();
        equipoAdapter =new EquipoAdapter(equipos);

        equiposLayoutManager=new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false);

        equiposRecyclerView =view.findViewById(R.id.equiposRecyclerView);
        equiposRecyclerView.setAdapter(equipoAdapter);
        equiposRecyclerView.setLayoutManager(equiposLayoutManager);

        equipos1RecyclerView =view.findViewById(R.id.equipos1RecyclerView);
        equipos1RecyclerView.setAdapter(equipoAdapter);
        equipos1RecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));

        equipos2RecyclerView =view.findViewById(R.id.equipos2RecyclerView);
        equipos2RecyclerView.setAdapter(equipoAdapter);
        equipos2RecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));

        return view;
    }

}
