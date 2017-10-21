package com.miguelch96.pichangapp.fragments.equipo.retos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.adapters.equipo.RetosEnviadosAdapter;
import com.miguelch96.pichangapp.repositories.EquipoRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class RetosEnviadosFragment extends Fragment {

    private RecyclerView enviadosRecyclerView;
    private RetosEnviadosAdapter enviadosAdapter;
    private RecyclerView.LayoutManager enviadosLayoutManager;


    public RetosEnviadosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_retos_enviados,container,false);

        enviadosAdapter =new RetosEnviadosAdapter(EquipoRepository.getRetos());

        enviadosLayoutManager=new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);

        enviadosRecyclerView =view.findViewById(R.id.enviadosRecyclerView);
        enviadosRecyclerView.setAdapter(enviadosAdapter);
        enviadosRecyclerView.setLayoutManager(enviadosLayoutManager);
        return  view;
    }

}
