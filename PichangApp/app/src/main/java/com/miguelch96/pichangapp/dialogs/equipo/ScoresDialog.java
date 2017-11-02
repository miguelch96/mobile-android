package com.miguelch96.pichangapp.dialogs.equipo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.models.Cancha;
import com.miguelch96.pichangapp.models.Comentario;
import com.miguelch96.pichangapp.models.Equipo;

import java.util.ArrayList;
import java.util.List;

public class ScoresDialog extends DialogFragment {

    private ListView listView;

    public class ItemComentAdapter extends ArrayAdapter<Comentario>
    {
        private List<Comentario> items;
        private ComentViewHolder comentHolder;
        private Context context;


        private class ComentViewHolder{
            TextView autorTextView;
            TextView comentTextView;
            RatingBar ratingBar;
        }

        public ItemComentAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Comentario> objects) {
            super(context, resource, objects);
            this.items = objects;
            this.context=context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater inflater = ((Activity)context).getLayoutInflater();
                v = inflater.inflate(R.layout.item_list_coment_equipo, parent, false);
                comentHolder = new ComentViewHolder();
                comentHolder.autorTextView = (TextView)v.findViewById(R.id.autorTextView);
                comentHolder.comentTextView = (TextView)v.findViewById(R.id.comentTextView);
                comentHolder.ratingBar = (RatingBar) v.findViewById(R.id.scoreRating);
                v.setTag(comentHolder);
            } else comentHolder = (ComentViewHolder) v.getTag();

            Comentario e = items.get(position);
            if (e != null) {
                comentHolder.autorTextView.setText(e.getUsuario());
                comentHolder.comentTextView.setText(e.getComentario());
                comentHolder.ratingBar.setRating(Float.valueOf(String.valueOf(e.getCalificacion())));
            }

            return v;

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        String value = bundle.getString("object");
        List<Comentario> comentarios = new ArrayList<>();

        if(value.equalsIgnoreCase("cancha"))
        {
            Cancha cancha = (Cancha) bundle.getSerializable("cancha");
            comentarios =cancha.getComentarios();
        }
        else if(value.equalsIgnoreCase("equipo"))
        {
            Equipo equipo = (Equipo) bundle.getSerializable("equipo");
            comentarios =equipo.getComentarios();
        }


        ItemComentAdapter adapter = new ItemComentAdapter(getActivity(),
                R.layout.item_list_coment_equipo, comentarios);

        /** Setting the array adapter to the list view */
        listView.setAdapter(adapter);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_scores, null);


        listView = view.findViewById(R.id.listComents);



        builder.setView(view);
        // Add action buttons
        AlertDialog alert = builder.create();
        return alert;
    }
}
