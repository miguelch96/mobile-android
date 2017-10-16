package com.miguelch96.pichangapp.fragments.equipo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.adapters.equipo.ElegirCanchaAdapter;
import com.miguelch96.pichangapp.repositories.CanchaRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElegirCanchaFragment extends Fragment {

    private RecyclerView canchasRecyclerView;
    private ElegirCanchaAdapter canchaAdapter;
    private RecyclerView.LayoutManager canchaLayoutManager;

    public ElegirCanchaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_elegir_cancha,container,false);

        canchaAdapter =new ElegirCanchaAdapter(CanchaRepository.getCanchas());

        canchaLayoutManager=new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);

        canchasRecyclerView =view.findViewById(R.id.selectCanchaRecyclerView);
        canchasRecyclerView.setAdapter(canchaAdapter);
        canchasRecyclerView.setLayoutManager(canchaLayoutManager);

        return view;
    }

}
