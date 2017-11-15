package com.miguelch96.pichangapp.fragments.cancha;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CanchaFavoritesFragment extends Fragment {

    private List<Cancha> favorites;
    private RecyclerView favoritesRecyclerView;
    private CanchaAdapter favoriteAdapter;
    private RecyclerView.LayoutManager favoriteLayoutManager;

    public CanchaFavoritesFragment() {
        // Required empty public constructor
    }

    public void updateData() {
        AndroidNetworking.get("http://miguelch96-001-site1.itempurl.com/api/canchas")
                .setPriority(Priority.LOW)
                .setTag(getString(R.string.app_name))
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            favorites = Cancha.fromFavorite(response.getJSONArray("canchas"));
                            favoriteAdapter.setCanchas(favorites);
                            favoriteAdapter.notifyDataSetChanged();


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
        View view=inflater.inflate(R.layout.fragment_cancha_favorites,container,false);
        favorites=new ArrayList<>();
        updateData();
        favoriteAdapter =new CanchaAdapter(favorites);

        favoriteLayoutManager=new GridLayoutManager(view.getContext(), 2);

        favoritesRecyclerView =view.findViewById(R.id.favoritesRecyclerView);
        favoritesRecyclerView.setAdapter(favoriteAdapter);
        favoritesRecyclerView.setLayoutManager(favoriteLayoutManager);
        return view;
    }

}
