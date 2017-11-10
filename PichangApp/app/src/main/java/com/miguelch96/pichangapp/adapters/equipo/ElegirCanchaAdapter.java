package com.miguelch96.pichangapp.adapters.equipo;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.dialogs.DiasDialog;
import com.miguelch96.pichangapp.models.Cancha;

import java.util.List;

/**
 * Created by Sergio on 15/10/2017.
 */

public class ElegirCanchaAdapter extends RecyclerView.Adapter<ElegirCanchaAdapter.ViewHolder> {

    private List<Cancha> canchas;

    public ElegirCanchaAdapter(List<Cancha> canchas) {
        this.canchas = canchas;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nombreTextView;
        TextView distritoTextView;
        TextView materialTextView;
        TextView capacidadTextView;
        TextView precioTextView;
        RelativeLayout canchaCardView;


        public ViewHolder(View itemView) {
            super(itemView);
            nombreTextView = (TextView) itemView.findViewById(R.id.nombreTextView);
            distritoTextView = (TextView) itemView.findViewById(R.id.distritoTextView);
            materialTextView = (TextView) itemView.findViewById(R.id.materialTextView);
            capacidadTextView = (TextView) itemView.findViewById(R.id.capacidadTextView);
            precioTextView=(TextView) itemView.findViewById(R.id.precioTextView);
            canchaCardView=(RelativeLayout) itemView.findViewById(R.id.canchaCardView);
        }
    }

    @Override
    public ElegirCanchaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_elegir_cancha,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ElegirCanchaAdapter.ViewHolder holder, int position) {
        final Cancha cancha= canchas.get(position);
        holder.nombreTextView.setText("Cancha: "+cancha.getNombre());
        holder.distritoTextView.setText("Distrito: "+cancha.getDistrito());
        holder.materialTextView.setText("Material: "+"Sintetico");
        holder.capacidadTextView.setText( "Capacidad: "+"Futbol 6");
        holder.precioTextView.setText("Precio dia/noche: "+String.valueOf(cancha.getPrecio()));
        holder.canchaCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Elegir horario
                Bundle bundle = ((Activity) view.getContext()).getIntent().getExtras();
                bundle.putSerializable("cancha",cancha);
                bundle.putString("object", "equipo");
                DialogFragment dialog = new DiasDialog();

                dialog.setArguments(bundle);
                dialog.show(((Activity) view.getContext()).getFragmentManager(), "DiasDialog");
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

    public void setCanchas(List<Cancha> canchas) {
        this.canchas = canchas;
    }
}
