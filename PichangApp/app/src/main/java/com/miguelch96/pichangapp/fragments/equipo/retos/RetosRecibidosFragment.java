package com.miguelch96.pichangapp.fragments.equipo.retos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.adapters.equipo.RetosRecibidosAdapter;
import com.miguelch96.pichangapp.repositories.EquipoRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class RetosRecibidosFragment extends Fragment {

    private RecyclerView recibidosRecyclerView;
    private RetosRecibidosAdapter recibidosAdapter;
    private RecyclerView.LayoutManager recibidosLayoutManager;



    public RetosRecibidosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_retos_recibidos,container,false);

        recibidosAdapter =new RetosRecibidosAdapter(EquipoRepository.getRetos());

        recibidosLayoutManager=new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);

        recibidosRecyclerView =view.findViewById(R.id.recibidosRecyclerView);
        recibidosRecyclerView.setAdapter(recibidosAdapter);
        recibidosRecyclerView.setLayoutManager(recibidosLayoutManager);
        return  view;
    }

}
