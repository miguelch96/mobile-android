package com.miguelch96.pichangapp.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Sergio on 17/10/2017.
 */

public class HorariosDialog extends DialogFragment {

    private ListView listHorarios;
    private ImageView backButton;
    private List<String> horarios;


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

       for (int i =0; i<c.getReservas().size(); i++){
           Reserva r = c.getReservas().get(i);
           if(dia.equalsIgnoreCase(r.getDia())){
               horarios.add(r.getHoras());
           }
       }

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
                    //putReserva(bundle);
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

    public void putReserva(Bundle bundle){
        Cancha c =(Cancha) bundle.getSerializable("cancha");
        String dia = bundle.getString("dia");
        String horario = bundle.getString("horario");
        String fecha =  String.valueOf(Calendar.getInstance().getFirstDayOfWeek());

        AndroidNetworking.post("https://fierce-cove-29863.herokuapp.com/createAnUser")
                .addBodyParameter("dia", dia)
                .addBodyParameter("horario", horario)
                .addBodyParameter("fecha", fecha)
                .addBodyParameter("idCancha", String.valueOf(c.getId()))
                .addBodyParameter("idUsuario", String.valueOf(1))
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
