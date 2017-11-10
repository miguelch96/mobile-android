package com.miguelch96.pichangapp.adapters.cancha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;
import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.activities.CanchaActivity;
import com.miguelch96.pichangapp.models.Cancha;

import java.util.List;

/**
 * Created by Miguel on 9/20/2017.
 */

public class CanchaAdapter extends RecyclerView.Adapter<CanchaAdapter.ViewHolder> {
    private List<Cancha> canchas;

    public CanchaAdapter(List<Cancha> canchas) {
        this.canchas = canchas;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ANImageView pictureImageView;
        TextView scoreTextView;
        TextView distritoTextView;
        TextView nombreTextView;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            nombreTextView=itemView.findViewById(R.id.nombreTextView);
            pictureImageView=itemView.findViewById(R.id.pictureImageView);
            distritoTextView=itemView.findViewById(R.id.distritoTextView);
            scoreTextView=itemView.findViewById(R.id.scoreTextView);
            cardView=itemView.findViewById(R.id.cancha_card);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_cancha,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {
        final Cancha cancha=canchas.get(position);
        holder.pictureImageView.setErrorImageResId(R.mipmap.ic_launcher);
        holder.pictureImageView.setDefaultImageResId(R.mipmap.ic_launcher);
        holder.pictureImageView.setImageUrl(cancha.getPictureUrl());
        holder.distritoTextView.setText(cancha.getDistrito());
        holder.scoreTextView.setText(String.valueOf(cancha.getScore()));
        holder.nombreTextView.setText(cancha.getNombre());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itemIntent = new Intent(view.getContext(), CanchaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("cancha", cancha);

                itemIntent.putExtras(bundle);
                view.getContext().startActivity(itemIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return canchas.size();
    }

    public List<Cancha> getCanchas() {
        return canchas;
    }

    public CanchaAdapter setCanchas(List<Cancha> canchas) {
        this.canchas = canchas;
        return this;
    }
}
