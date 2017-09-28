package com.miguelch96.pichangapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.miguelch96.pichangapp.R;

import java.util.List;

/**
 * Created by Sergio on 28/09/2017.
 */

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder> {

    private List<Integer> pictures;

    public PictureAdapter(List<Integer> pictures) {
        this.pictures = pictures;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView pictureImageView;


        public ViewHolder(View itemView) {
            super(itemView);
            pictureImageView = itemView.findViewById(R.id.pictureImageView);

        }
    }

    @Override
    public PictureAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_equipo_pictures,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PictureAdapter.ViewHolder holder, int position) {
        holder.pictureImageView.setImageResource(pictures.get(position));
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }


}
