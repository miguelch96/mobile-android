package com.miguelch96.pichangapp.adapters.cancha;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
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
        this.setCanchas(canchas);
    }

    public CanchaAdapter(){
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_cancha,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Cancha cancha=canchas.get(position);
        holder.pictureImageView.setErrorImageResId(R.mipmap.ic_launcher);
        holder.pictureImageView.setDefaultImageResId(R.mipmap.ic_launcher);
        holder.pictureImageView.setImageUrl(cancha.getPictureUrl());
        holder.distritoTextView.setText(cancha.getDistrito());
        holder.scoreTextView.setText(String.valueOf(cancha.getScore()));

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
        return getCanchas().size();
    }

    public List<Cancha> getCanchas() {
        return canchas;
    }

    public CanchaAdapter setCanchas(List<Cancha> canchas) {
        this.canchas = canchas;
        return this;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ANImageView pictureImageView;
        TextView scoreTextView;
        TextView distritoTextView;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            pictureImageView=itemView.findViewById(R.id.pictureImageView);
            distritoTextView=itemView.findViewById(R.id.distritocardTextView);
            scoreTextView=itemView.findViewById(R.id.scoreTextView);
            cardView=itemView.findViewById(R.id.cancha_card);

        }
    }
}
