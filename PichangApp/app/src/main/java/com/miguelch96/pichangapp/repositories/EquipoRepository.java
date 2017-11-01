package com.miguelch96.pichangapp.repositories;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.models.Equipo;
import com.miguelch96.pichangapp.models.Reto;
import com.miguelch96.pichangapp.models.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergio on 26/09/2017.
 */

public class EquipoRepository {



    public static List<Equipo> getEquipos()
    {
        List<Equipo> equipos = new ArrayList<>();





        equipos.add(new Equipo(0, "Sport Gusto", "Pueblo libre", "Futbol 6", null,null ,null, 4.3, null,null));
        equipos.add(new Equipo(0, "Peloteros", "SJL", "Futbol 6", null,null, null, 3.2,null,null));
        equipos.add(new Equipo(0, "Universitario", "Breña", "Futbol 11", null,null,null, 5.0,null,null));
        equipos.add(new Equipo(0, "Cremas", "San isidro", "Futbol 12", null,null,null, 0, null,null));
        return equipos;
    }

    public static  List<Reto> getRetos()
    {
        List<Reto> retos = new ArrayList<>();
        retos.add(new Reto(0,getEquipos().get(1), getEquipos().get(0), "10/06/18", CanchaRepository.getCanchas().get(0),"Pendiente"));
        retos.add(new Reto(1,getEquipos().get(2), getEquipos().get(0), "17/06/18", CanchaRepository.getCanchas().get(1),"Pendiente"));
        retos.add(new Reto(2,getEquipos().get(3), getEquipos().get(0), "23/06/18", CanchaRepository.getCanchas().get(2),"Pendiente"));


        return retos;
    }
}
