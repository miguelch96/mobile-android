package com.miguelch96.pichangapp.adapters.horario;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.models.Reserva;
import com.miguelch96.pichangapp.network.ConvocadosAPI;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by Miguel on 11/20/2017.
 */

public class ReservaAdapter extends RecyclerView.Adapter<ReservaAdapter.ViewHolder>  {

    List<Reserva> reservas;

    public List<Reserva> getReservas() {
        return reservas;
    }

    public ReservaAdapter setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
        return this;
    }


    public ReservaAdapter(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_horario,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ReservaAdapter.ViewHolder holder, int position) {
        final Reserva reserva=reservas.get(position);

        holder.nameCardHorarioTextView.setText(reserva.getHoras());

        holder.nameCardHorarioTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putReserva(reserva);
            }
        });
    }

    public void putReserva(Reserva reserva){

        AndroidNetworking.put(ConvocadosAPI.RESERVAS+reserva.getId())
                .addBodyParameter("reservaId", String.valueOf(reserva.getId()))
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

    @Override
    public int getItemCount() {
        return reservas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameCardHorarioTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            nameCardHorarioTextView=itemView.findViewById(R.id.nameCardHorarioTextView);
        }
    }
}
