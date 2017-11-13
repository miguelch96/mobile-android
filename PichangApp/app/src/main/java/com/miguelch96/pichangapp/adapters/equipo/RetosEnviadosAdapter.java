package com.miguelch96.pichangapp.adapters.equipo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.miguelch96.pichangapp.R;

import com.miguelch96.pichangapp.activities.CanchaActivity;
import com.miguelch96.pichangapp.activities.EquipoActivity;
import com.miguelch96.pichangapp.models.Cancha;
import com.miguelch96.pichangapp.models.Equipo;
import com.miguelch96.pichangapp.models.Reto;

import java.util.List;

/**
 * Created by Sergio on 19/10/2017.
 */

public class RetosEnviadosAdapter extends RecyclerView.Adapter<RetosEnviadosAdapter.ViewHolder>  {

    private List<Reto> retos;
    private List<Equipo> equipos;
    private List<Cancha> canchas;

    public RetosEnviadosAdapter(List<Reto> retos) {
        this.retos = retos;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView equipoTextView;
        TextView fechaTextView;
        TextView estadoTextView;
        Button equipoButton;
        Button canchaButton;

        public ViewHolder(View itemView) {
            super(itemView);
            equipoTextView = itemView.findViewById(R.id.equipoTextView);
            fechaTextView = itemView.findViewById(R.id.fechaTextView);
            estadoTextView = itemView.findViewById(R.id.estadoTextView);
            equipoButton = itemView.findViewById(R.id.equipoButton);
            canchaButton = itemView.findViewById(R.id.canchaButton);
        }
    }


    @Override
    public RetosEnviadosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_reto_enviado,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RetosEnviadosAdapter.ViewHolder holder, int position) {

        final Reto reto = retos.get(position);
        holder.equipoTextView.setText("Rival: " + String.valueOf(reto.getRetado()));
        holder.fechaTextView.setText("Fecha "+reto.getFecha());
        holder.estadoTextView.setText("Estado: "+reto.getEstado());
        holder.equipoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itemIntent = new Intent(view.getContext(), EquipoActivity.class);
                Bundle bundle = new Bundle();
                for (int i = 0; i<equipos.size(); i++){

                    Equipo e = equipos.get(i);
                    if(e.getEquipoId()==reto.getRetado()){
                        bundle.putSerializable("equipo", e);
                        break;
                    }
                }

                itemIntent.putExtras(bundle);
                view.getContext().startActivity(itemIntent);
            }
        });
        holder.canchaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent=new Intent(context, CanchaActivity.class);
                Bundle bundle = new Bundle();
                for (int i = 0; i<canchas.size(); i++){

                    Cancha c = canchas.get(i);
                    if(c.getId()==reto.getCancha()){
                        bundle.putSerializable("cancha", c);
                        break;
                    }
                }
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
            return getRetos().size();
    }

    public List<Reto> getRetos() {
        return retos;
    }

    public void setRetos(List<Reto> retos) {
        this.retos = retos;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public List<Cancha> getCanchas() {
        return canchas;
    }

    public void setCanchas(List<Cancha> canchas) {
        this.canchas = canchas;
    }
}
