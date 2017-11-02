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
import com.miguelch96.pichangapp.adapters.cancha.CanchaAdapter;
import com.miguelch96.pichangapp.models.Cancha;
import com.miguelch96.pichangapp.repositories.CanchaRepository;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CanchasFragment extends Fragment {

    private RecyclerView canchasRecyclerView;
    private CanchaAdapter canchaAdapter;
    private RecyclerView.LayoutManager canchasLayoutManager;
    private List<Cancha> canchas;

    public CanchasFragment() {
        // Required empty public constructor
    }

    public void updateData() {
        AndroidNetworking.get("http://pichangappservice.azurewebsites.net/api/canchas")
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_canchas,container,false);
        canchas= new ArrayList<>();
        updateData();
        canchaAdapter=new CanchaAdapter(CanchaRepository.getCanchas());

        canchasLayoutManager=new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false);
//        canchasLayoutManager=new GridLayoutManager(view.getContext(),2);

        canchasRecyclerView=view.findViewById(R.id.canchasRecyclerView);
        canchasRecyclerView.setAdapter(canchaAdapter);
        canchasRecyclerView.setLayoutManager(canchasLayoutManager);

        return view;
    }

}
