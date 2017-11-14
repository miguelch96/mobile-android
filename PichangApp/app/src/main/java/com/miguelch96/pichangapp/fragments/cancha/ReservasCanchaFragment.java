package com.miguelch96.pichangapp.fragments.cancha;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReservasCanchaFragment extends Fragment {

    private ListView listView;
    private List<Reserva> lista;
    private ReservaAdapter adapter;

    public ReservasCanchaFragment() {
        // Required empty public constructor
    }

    public class ReservaAdapter extends BaseAdapter
    {
        Context context;
        private List<Reserva> reservas;

        public ReservaAdapter(Context context, List<Reserva> reservas) {
            this.context = context;
            this.reservas = reservas;
        }

        @Override
        public int getCount() {
            return reservas.size();
        }

        @Override
        public Object getItem(int i) {
            return reservas.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(context).
                        inflate(R.layout.item_list_reserva_cancha, parent, false);
            }

            // get current item to be displayed
            Reserva currentItem = (Reserva) getItem(position);

            // get the TextView for item name and item description
            TextView canchaTextView = (TextView)
                    convertView.findViewById(R.id.canchaTextView);
            TextView fechaTextView = (TextView)
                    convertView.findViewById(R.id.fechaTextView);
            TextView direccionTextView = (TextView)
                    convertView.findViewById(R.id.direccionTextView);
            TextView horasTextView = (TextView)
                    convertView.findViewById(R.id.horasTextView);

            //sets the text for item name and item description from the current item object
            canchaTextView.setText("Cancha: " + currentItem.getCancha());
            fechaTextView.setText("Fecha: " + currentItem.getFecha());
            direccionTextView.setText("Dirección: "+currentItem.getDireccion());
            horasTextView.setText("Horas: "+currentItem.getHoras());

            // returns the view for the current row
            return convertView;
        }

        public List<Reserva> getReservas() {
            return reservas;
        }

        public void setReservas(List<Reserva> reservas) {
            this.reservas = reservas;
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_reservas_cancha, container, false);
        lista= new ArrayList<>();
        updateData();
        adapter = new ReservaAdapter(getActivity(), lista);
        listView =(ListView) view.findViewById(R.id.listReservas);


        listView.setAdapter(adapter);


       return view;
    }

    public void updateData() {
        AndroidNetworking.get("http://miguelch96-001-site1.itempurl.com/api/usuarios/1/reservas")
                .setPriority(Priority.LOW)
                .setTag(getString(R.string.app_name))
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                           lista = Reserva.from(response.getJSONArray("reservasRealizadas"));
                            adapter.setReservas(lista);
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
