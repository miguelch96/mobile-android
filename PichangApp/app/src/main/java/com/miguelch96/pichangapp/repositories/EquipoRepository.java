package com.miguelch96.pichangapp.repositories;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.models.Equipo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergio on 26/09/2017.
 */

public class EquipoRepository {

    public static List<Equipo> getEquipos()
    {
        List<Equipo> equipos = new ArrayList<>();
        List<Integer> pictures = new ArrayList<>();
        pictures.add(R.drawable.pic1);
        pictures.add(R.drawable.pic2);
        pictures.add(R.drawable.pic3);
        equipos.add(new Equipo(0, "Sport Gusto", "Pueblo libre", "Futbol 6", null,null, null,pictures, 4.3, R.drawable.equipo1));
        equipos.add(new Equipo(0, "Peloteros", "SJL", "Futbol 6", null,null, null,pictures, 3.2, R.drawable.equipo2));
        equipos.add(new Equipo(0, "Universitario", "Breña", "Futbol 11", null,null, null,pictures, 5.0, R.drawable.equipo3));
        equipos.add(new Equipo(0, "Cremas", "San isidro", "Futbol 12", null,null, null,pictures, 0, R.drawable.equipo4));
        return equipos;
    }
}
