package com.miguelch96.pichangapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.adapters.CanchaAdapter;
import com.miguelch96.pichangapp.models.CanchaRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class CanchasFragment extends Fragment {

    private RecyclerView canchasRecyclerView;
    private CanchaAdapter canchaAdapter;
    private RecyclerView.LayoutManager canchasLayoutManager;

    public CanchasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_canchas,container,false);

        canchaAdapter=new CanchaAdapter(CanchaRepository.getCanchas());

        canchasLayoutManager=new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false);
//        canchasLayoutManager=new GridLayoutManager(view.getContext(),2);

        canchasRecyclerView=view.findViewById(R.id.canchasRecyclerView);
        canchasRecyclerView.setAdapter(canchaAdapter);
        canchasRecyclerView.setLayoutManager(canchasLayoutManager);

        return view;
    }

}
