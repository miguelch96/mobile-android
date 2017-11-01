package com.miguelch96.pichangapp.adapters.equipo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidnetworking.widget.ANImageView;
import com.miguelch96.pichangapp.R;

import java.util.List;

/**
 * Created by Sergio on 28/09/2017.
 */

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder> {

    private List<String> pictures;

    public PictureAdapter(List<String> pictures) {
        this.pictures = pictures;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ANImageView pictureImageView;


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
        String value = pictures.get(position);

        holder.pictureImageView.setImageUrl(value);
        holder.pictureImageView.setErrorImageResId(R.mipmap.ic_launcher);
        holder.pictureImageView.setDefaultImageResId(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return pictures==null? 0 : pictures.size();
    }


}
