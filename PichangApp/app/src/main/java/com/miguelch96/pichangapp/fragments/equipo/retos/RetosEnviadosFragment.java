package com.miguelch96.pichangapp.fragments.equipo.retos;


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
import com.miguelch96.pichangapp.adapters.equipo.RetosEnviadosAdapter;
import com.miguelch96.pichangapp.models.Cancha;
import com.miguelch96.pichangapp.models.Equipo;
import com.miguelch96.pichangapp.models.Reto;
import com.miguelch96.pichangapp.models.Session;
import com.miguelch96.pichangapp.repositories.EquipoRepository;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RetosEnviadosFragment extends Fragment {

    private RecyclerView enviadosRecyclerView;
    private RetosEnviadosAdapter enviadosAdapter;
    private RecyclerView.LayoutManager enviadosLayoutManager;
    private List<Reto> retos;

    public RetosEnviadosFragment() {
        // Required empty public constructor
    }
    public void updateData() {
        AndroidNetworking.get("http://miguelch96-001-site1.itempurl.com/api/equipos/1")
                .setPriority(Priority.LOW)
                .setTag(getString(R.string.app_name))
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            retos = Equipo.from(response.getJSONObject("equipo")).getRetosEnviados();
                            enviadosAdapter.setRetos(retos);
                            enviadosAdapter.notifyDataSetChanged();


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

    public void updateEquipos() {
        AndroidNetworking.get("http://miguelch96-001-site1.itempurl.com/api/equipos")
                .setPriority(Priority.LOW)
                .setTag(getString(R.string.app_name))
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            enviadosAdapter.setEquipos(Equipo.from(response.getJSONArray("equipos")));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }

    public void updateCanchas() {
        AndroidNetworking.get("http://miguelch96-001-site1.itempurl.com/api/canchas")
                .setPriority(Priority.LOW)
                .setTag(getString(R.string.app_name))
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            enviadosAdapter.setCanchas(Cancha.from(response.getJSONArray("canchas")));



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
        View view=inflater.inflate(R.layout.fragment_retos_enviados,container,false);
        retos = new ArrayList<>();

        updateCanchas();
        updateEquipos();
        updateData();
        enviadosAdapter =new RetosEnviadosAdapter(retos);

        enviadosLayoutManager=new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);

        enviadosRecyclerView =view.findViewById(R.id.enviadosRecyclerView);
        enviadosRecyclerView.setAdapter(enviadosAdapter);
        enviadosRecyclerView.setLayoutManager(enviadosLayoutManager);
        return  view;
    }

}
