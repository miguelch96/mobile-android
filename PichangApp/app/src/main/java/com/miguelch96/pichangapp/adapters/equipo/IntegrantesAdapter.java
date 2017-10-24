package com.miguelch96.pichangapp.adapters.equipo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.miguelch96.pichangapp.R;

import java.util.ArrayList;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Sergio on 28/09/2017.
 */

public class IntegrantesAdapter extends RecyclerView.Adapter<IntegrantesAdapter.ViewHolder> {

    private final ArrayList mData;

    public IntegrantesAdapter(Map<String,Integer> map) {
        mData = new ArrayList();
        mData.addAll(map.entrySet());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{


        CircleImageView pictureImageView;
        TextView nombreTextView;



        public ViewHolder(View itemView) {
            super(itemView);
            pictureImageView = itemView.findViewById(R.id.pictureImageView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
        }
    }


    @Override
    public IntegrantesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_integrante,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(IntegrantesAdapter.ViewHolder holder, int position) {
        Map.Entry<String, Integer> item = getItem(position);


            holder.pictureImageView.setImageResource(item.getValue());
            holder.nombreTextView.setText(item.getKey());
    }

    public Map.Entry<String, Integer> getItem(int position) {
        return (Map.Entry) mData.get(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


}