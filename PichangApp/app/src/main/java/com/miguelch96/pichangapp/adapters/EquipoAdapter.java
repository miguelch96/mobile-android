package com.miguelch96.pichangapp.adapters;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.activities.EquipoActivity;
import com.miguelch96.pichangapp.models.Equipo;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import java.util.List;

/**
 * Created by Sergio on 26/09/2017.
 */

public class EquipoAdapter extends RecyclerView.Adapter<EquipoAdapter.ViewHolder> {

    private List<Equipo> equipos;

    public EquipoAdapter(List<Equipo> equipos) {
        this.setEquipos(equipos);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pictureImageView;
        TextView nombreTextView;
        TextView distritoTextView;
        TextView scoreTextView;
        CardView cardView;

        public  ViewHolder(View itemView) {
            super(itemView);
            pictureImageView=itemView.findViewById(R.id.pictureImageView);
            nombreTextView=itemView.findViewById(R.id.nombreTextView);
            distritoTextView=itemView.findViewById(R.id.distritoTextView);
            scoreTextView=itemView.findViewById(R.id.scoreTextView);
            cardView=itemView.findViewById(R.id.equipo_card);

        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_equipo,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {
        final Equipo equipo= equipos.get(position);

        holder.pictureImageView.setImageResource(equipo.getPicture());
        holder.nombreTextView.setText(equipo.getNombre());
        holder.distritoTextView.setText(equipo.getDistrito());
        holder.scoreTextView.setText(String.valueOf(equipo.getScore()));


                holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent itemIntent = new Intent(v.getContext(), EquipoActivity.class);
                Bundle bundle = new Bundle();
               bundle.putSerializable("equipo", equipo);

                itemIntent.putExtras(bundle);
                v.getContext().startActivity(itemIntent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return getEquipos().size();
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public EquipoAdapter setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
        return this;
    }




}
