package com.miguelch96.pichangapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.adapters.EquipoAdapter;
import com.miguelch96.pichangapp.repositories.EquipoRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class EquiposFragment extends Fragment {

    private RecyclerView equiposRecyclerView;
    private EquipoAdapter equipoAdapter;
    private RecyclerView.LayoutManager equiposLayoutManager;

    public EquiposFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_equipos,container,false);

        equipoAdapter =new EquipoAdapter(EquipoRepository.getEquipos());

        equiposLayoutManager=new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false);

        equiposRecyclerView =view.findViewById(R.id.equiposRecyclerView);
        equiposRecyclerView.setAdapter(equipoAdapter);
        equiposRecyclerView.setLayoutManager(equiposLayoutManager);

        return view;
    }

}
