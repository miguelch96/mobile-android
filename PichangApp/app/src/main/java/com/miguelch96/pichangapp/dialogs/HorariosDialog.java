package com.miguelch96.pichangapp.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.dialogs.equipo.ConfirmacionDialog;
import com.miguelch96.pichangapp.models.Cancha;
import com.miguelch96.pichangapp.models.Reserva;
import com.miguelch96.pichangapp.network.ConvocadosAPI;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Sergio on 17/10/2017.
 */

public class HorariosDialog extends DialogFragment {

    private ListView listHorarios;
    private ImageView backButton;
    private List<String> horarios;
    private List<Reserva> reservas;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_horarios, null);

        listHorarios = (ListView)view.findViewById(R.id.listviewHorarios);
        Bundle bundle = getArguments();
        String dia = bundle.getString("dia");
        Cancha c =(Cancha) bundle.getSerializable("cancha");
        horarios = new ArrayList<>();


        buscarReservasDisponibles(bundle);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, horarios);

        listHorarios.setAdapter(adaptador);

        listHorarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = (String)adapterView.getItemAtPosition(i);

                Bundle bundle = getArguments();
                String v = bundle.getString("object");
                bundle.putString("horario",value);

                if(v.equalsIgnoreCase("equipo")){
                    DialogFragment dialog = new ConfirmacionDialog();
                    dialog.setArguments(bundle);
                    dialog.show(getFragmentManager(), "ConfirmacionDialog");
                }
                else if(v.equalsIgnoreCase("cancha")){
                    putReserva(bundle,i);
                    DialogFragment dialog = new MessageDialog();
                    String message = "!Reserva realizada con exito!";
                    bundle.putString("message", message);
                    bundle.putString("title", "¡En hora buena!");
                    dialog.setArguments(bundle);
                    dialog.show(getFragmentManager(), "MessageDialog");
                }

            }
        });

        backButton = view.findViewById(R.id.backImageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        builder.setView(view);
        AlertDialog alert = builder.create();
        return alert;
    }


    public void buscarReservasDisponibles(Bundle bundle){
        Cancha c =(Cancha) bundle.getSerializable("cancha");
        String dia = bundle.getString("dia");
        final String horario = bundle.getString("horario");
        String fecha =  String.valueOf(Calendar.getInstance().getFirstDayOfWeek());

        reservas=new ArrayList<>();

        String url = ConvocadosAPI.CANCHAS+c.getId()+"/reservaslibres";
        Log.d("CONSULTAPI",url);
        AndroidNetworking.get(url)
                .addQueryParameter("fecha", "2017-11-09")
                .setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            reservas = Reserva.from(response.getJSONArray("reservasDisponibles"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        for (int i=0;i<reservas.size();i++){
                            horarios.add(reservas.get(i).getHoras());
                        }
                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                    }
                });
    }

    public void putReserva(Bundle bundle,int i){
        Cancha c =(Cancha) bundle.getSerializable("cancha");
        String dia = bundle.getString("dia");
        String horario = bundle.getString("horario");
        String fecha =  String.valueOf(Calendar.getInstance().getFirstDayOfWeek());


        int reservaid= reservas.get(i).getId();
        Log.d("reservaId", String.valueOf(reservaid));
        AndroidNetworking.put(ConvocadosAPI.RESERVAS+reservaid)
                .addBodyParameter("reservaId", String.valueOf(reservaid))
                .addBodyParameter("usuarioId", "1")
                .addBodyParameter("estado", "Ocupado")
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                    }
                });
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        getDialog().getWindow().setGravity(Gravity.BOTTOM);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
