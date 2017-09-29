package com.miguelch96.pichangapp.repositories;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.models.Equipo;

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

        List<String> coments = new ArrayList<>();
        coments.add("Equipo facil.");
        coments.add("Pelea el partido hasta el final.");
        coments.add("Son muy malos!");
        coments.add("Mejor jueguen voley");
        coments.add("Rapiditos.");

        Map<String, Integer> integrantes = new HashMap<>();
        integrantes.put("Sergio Luyo",R.drawable.int1);
        integrantes.put("Miguel Chipana",R.drawable.int2);
        integrantes.put("David Molina",R.drawable.int3);
        integrantes.put("Pedro Luyo",R.drawable.int1);
        integrantes.put("Roberto Chipana",R.drawable.int2);
        integrantes.put("Juan Molina",R.drawable.int3);


        equipos.add(new Equipo(0, "Sport Gusto", "Pueblo libre", "Futbol 6", coments,skills,pictures, 4.3, R.drawable.equipo1,integrantes));
        equipos.add(new Equipo(0, "Peloteros", "SJL", "Futbol 6", coments,skills, pictures, 3.2, R.drawable.equipo2,integrantes));
        equipos.add(new Equipo(0, "Universitario", "Breña", "Futbol 11", coments,skills,pictures, 5.0, R.drawable.equipo3,integrantes));
        equipos.add(new Equipo(0, "Cremas", "San isidro", "Futbol 12", coments,skills,pictures, 0, R.drawable.equipo4,integrantes));
        return equipos;
    }
}
