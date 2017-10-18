package com.miguelch96.pichangapp.fragments.equipo;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.models.Equipo;
import com.miguelch96.pichangapp.repositories.EquipoRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReservasEquipoFragment extends ListFragment {

    private ListView listView;

    public class ItemEquipoAdapter extends ArrayAdapter<Equipo>
    {

        private List<Equipo> items;
        private EquipoViewHolder equipoHolder;
        private Context context;


        private class EquipoViewHolder
        {
            TextView rivalTextView;
            TextView canchaTextView;
            TextView fechaTextView;
        }
        public ItemEquipoAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Equipo> objects) {
            super(context, resource, objects);
            this.items = objects;
            this.context=context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater inflater = ((Activity)context).getLayoutInflater();
                v = inflater.inflate(R.layout.item_list_reserva_equipo, parent, false);
                equipoHolder = new EquipoViewHolder();
                equipoHolder.rivalTextView = (TextView)v.findViewById(R.id.rivalTextView);
                equipoHolder.canchaTextView = (TextView)v.findViewById(R.id.canchaTextView);
                equipoHolder.fechaTextView = (TextView)v.findViewById(R.id.fechaTextView);
                v.setTag(equipoHolder);
            } else equipoHolder = (EquipoViewHolder) v.getTag();

            Equipo e = items.get(position);

            if (e != null) {
                equipoHolder.rivalTextView.setText("Rival: "+e.getNombre());
                equipoHolder.canchaTextView.setText("Cancha: "+"Matamula");
                equipoHolder.fechaTextView.setText("Fecha: "+"08/09/18 - 10pm");
            }

            return v;
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


        listView = view.findViewById(R.id.listEquipos);

        return view ;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
       super.onActivityCreated(savedInstanceState);
       List<Equipo> lista = EquipoRepository.getEquipos();

        ItemEquipoAdapter adapter = new ItemEquipoAdapter(getActivity(),
                R.layout.item_list_reserva_equipo, lista);

        /** Setting the array adapter to the list view */
       listView.setAdapter(adapter);
       // setListAdapter(adapter);
    }
}
