package com.miguelch96.pichangapp.repositories;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.models.Equipo;
import com.miguelch96.pichangapp.models.Reto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        List<Double> skills = new ArrayList<>();
        skills.add(3.4);
        skills.add(4.0);
        skills.add(2.8);




        equipos.add(new Equipo(0, "Sport Gusto", "Pueblo libre", "Futbol 6", null,skills,pictures, 4.3, null,null));
        equipos.add(new Equipo(0, "Peloteros", "SJL", "Futbol 6", null,skills, pictures, 3.2,null,null));
        equipos.add(new Equipo(0, "Universitario", "Breña", "Futbol 11", null,skills,pictures, 5.0,null,null));
        equipos.add(new Equipo(0, "Cremas", "San isidro", "Futbol 12", null,skills,pictures, 0, null,null));
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
