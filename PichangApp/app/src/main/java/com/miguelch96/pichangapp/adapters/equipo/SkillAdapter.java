package com.miguelch96.pichangapp.adapters.equipo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;
import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.models.Skill;

import java.util.List;

/**
 * Created by Sergio on 31/10/2017.
 */

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.ViewHolder>  {

    private List<Skill> skills;

    public SkillAdapter(List<Skill> skills) {
        this.skills = skills;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ANImageView imageSkill;
        TextView nombreSkill;
        TextView cantidadTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageSkill = itemView.findViewById(R.id.skillImage);
            nombreSkill = itemView.findViewById(R.id.nombreTextView);
            cantidadTextView = itemView.findViewById(R.id.cantidadTextView);
        }
    }


    @Override
    public SkillAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_skill_equipo,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SkillAdapter.ViewHolder holder, int position) {

        Skill skill = skills.get(position);

        holder.imageSkill.setImageUrl(skill.getImageUrl());
        holder.imageSkill.setDefaultImageResId(R.mipmap.ic_launcher);
        holder.imageSkill.setErrorImageResId(R.mipmap.ic_launcher);
        holder.nombreSkill.setText(skill.getNombre());
        holder.cantidadTextView.setText(String.valueOf(skill.getCantidad()));
    }

    @Override
    public int getItemCount() {
        return skills.size();
    }


}
