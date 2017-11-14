package com.miguelch96.pichangapp.fragments.equipo;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.models.Equipo;
import com.miguelch96.pichangapp.models.Reserva;
import com.miguelch96.pichangapp.models.Reto;
import com.miguelch96.pichangapp.repositories.EquipoRepository;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReservasEquipoFragment extends Fragment {

    private ListView listView;
    private List<Reto> lista;
    private ItemEquipoAdapter adapter;


    public class ItemEquipoAdapter extends BaseAdapter
    {
        Context context;
        private List<Reto> retos;

        public ItemEquipoAdapter(Context context, List<Reto> retos) {
            this.context = context;
            this.retos = retos;
        }

        @Override
        public int getCount() {
            return retos.size();
        }

        @Override
        public Object getItem(int i) {
            return retos.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(context).
                        inflate(R.layout.item_list_reserva_equipo, parent, false);
            }

            // get current item to be displayed
            Reto currentItem = (Reto) getItem(position);

            // get the TextView for item name and item description
            TextView rivalTextView = (TextView)
                    convertView.findViewById(R.id.rivalTextView);
            TextView canchaTextView = (TextView)
                    convertView.findViewById(R.id.canchaTextView);
            TextView fechaTextView = (TextView)
                    convertView.findViewById(R.id.fechaTextView);

            //sets the text for item name and item description from the current item object
            rivalTextView.setText("Rival: " + currentItem.getNombreRival());
            canchaTextView.setText("Cancha: " + currentItem.getNombreCancha());
            fechaTextView.setText("Fecha: " + currentItem.getFecha());

            // returns the view for the current row
            return convertView;
        }

        public List<Reto> getRetos() {
            return retos;
        }

        public void setRetos(List<Reto> retos) {
            this.retos = retos;
        }
    }



    public ReservasEquipoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reservas_equipo, container, false);
        List<Reto> p = new ArrayList<>();
        p.add(new Reto(0,1,2,"fecha", 1,"aceptado","rival", "cancha"));
        p.add(new Reto(0,1,2,"fecha", 1,"aceptado","rival", "cancha"));
        p.add(new Reto(0,1,2,"fecha", 1,"aceptado","rival", "cancha"));
        lista= new ArrayList<>();
        updateData();
        adapter = new ItemEquipoAdapter(getActivity(), lista);
        listView =(ListView) view.findViewById(R.id.listReservas);


        listView.setAdapter(adapter);


        return view ;
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

                            lista = Equipo.from(response.getJSONObject("equipo")).getRetosAceptados();
                            adapter.setRetos(lista);
                            adapter.notifyDataSetChanged();

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
}
