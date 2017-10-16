package com.miguelch96.pichangapp.adapters.cancha;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

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
        holder.pictureImageView.setImageResource(R.drawable.cancha1);
        holder.precioTextView.setText("S/. "+cancha.getPrecio());
        holder.distritoTextView.setText(cancha.getDistrito());
        holder.rateRatingBar.setRating(cancha.getCalificacion());

        holder.pictureImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent=new Intent(context, CanchaActivity.class);
                intent.putExtras(cancha.toBundle());
                context.startActivity(intent);

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
        ImageView pictureImageView;
        TextView precioTextView;
        TextView distritoTextView;
        RatingBar rateRatingBar;

        public ViewHolder(View itemView) {
            super(itemView);
            pictureImageView=itemView.findViewById(R.id.picturecardImageView);
            precioTextView=itemView.findViewById(R.id.preciocardTextView);
            distritoTextView=itemView.findViewById(R.id.distritocardTextView);
            rateRatingBar=itemView.findViewById(R.id.ratecardRatingBar);

        }
    }
}
