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

        equipos.add(new Equipo(0, "Sport Gusto", "Pueblo libre", "Futbol 6", null,null, null, 4.3, R.drawable.equipo1));
        equipos.add(new Equipo(0, "Sport tu madre", "SJL", "Futbol 6", null,null, null, 3.2, R.drawable.equipo1));
        equipos.add(new Equipo(0, "Universitario", "El templo", "Futbol 11", null,null, null, 5.0, R.drawable.equipo1));
        equipos.add(new Equipo(0, "Alianza Meza", "Watuter", "Futbol 12", null,null, null, 0, R.drawable.equipo1));
        return equipos;
    }
}
