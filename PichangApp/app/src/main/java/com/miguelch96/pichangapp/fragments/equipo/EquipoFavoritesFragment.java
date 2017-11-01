package com.miguelch96.pichangapp.fragments.equipo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
import com.miguelch96.pichangapp.fragments.EquiposFragment;
import com.miguelch96.pichangapp.models.Equipo;
import com.miguelch96.pichangapp.models.Favorite;
import com.miguelch96.pichangapp.repositories.EquipoRepository;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A simple {@link Fragment} subclass.
 */
public class EquipoFavoritesFragment extends Fragment {

    private List<Equipo> favorites;
    private RecyclerView favoritesRecyclerView;
    private EquipoAdapter favoriteAdapter;
    private RecyclerView.LayoutManager favoriteLayoutManager;


    public EquipoFavoritesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_equipo_favorites,container,false);
        favorites=new ArrayList<>();
        favoriteAdapter =new EquipoAdapter(favorites);

        favoriteLayoutManager=new GridLayoutManager(view.getContext(), 2);

        favoritesRecyclerView =view.findViewById(R.id.favoritesRecyclerView);
        favoritesRecyclerView.setAdapter(favoriteAdapter);
        favoritesRecyclerView.setLayoutManager(favoriteLayoutManager);
        return view;
    }

}
