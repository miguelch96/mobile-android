package com.miguelch96.pichangapp.fragments.equipo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.adapters.equipo.EquipoAdapter;
import com.miguelch96.pichangapp.models.Equipo;
import com.miguelch96.pichangapp.models.Favorite;

import java.util.ArrayList;
import java.util.List;

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
        List<Favorite> f = new ArrayList<>();
        f=Favorite.listAll(Favorite.class);
        for (int i = 0; i<f.size();i++)
        {
            favorites.add(f.get(i).getEquipo());
        }
        favoriteAdapter =new EquipoAdapter(favorites);

        favoriteLayoutManager=new GridLayoutManager(view.getContext(), 2);

        favoritesRecyclerView =view.findViewById(R.id.favoritesRecyclerView);
        favoritesRecyclerView.setAdapter(favoriteAdapter);
        favoritesRecyclerView.setLayoutManager(favoriteLayoutManager);
        return view;
    }

}
