package com.miguelch96.pichangapp.models;

import com.miguelch96.pichangapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miguel on 9/20/2017.
 */

public class CanchaRepository {
    public static List<Cancha> getCanchas() {
        List<Cancha> canchas = new ArrayList<>();
        canchas.add(new Cancha(1, "Cancha 1", "Distrito 1",4,120,R.drawable.cancha1));
        canchas.add(new Cancha(2, "Cancha 2", "Distrito 2",3,100,R.drawable.cancha1));
        canchas.add(new Cancha(3, "Cancha 3", "Distrito 3",5,110,R.drawable.cancha1));
        canchas.add(new Cancha(4, "Cancha 4", "Distrito 4",4,90,R.drawable.cancha1));
        canchas.add(new Cancha(5, "Cancha 5", "Distrito 5",3,95,R.drawable.cancha1));
        canchas.add(new Cancha(6, "Cancha 6", "Distrito 5",3,95,R.drawable.cancha1));
        canchas.add(new Cancha(7, "Cancha 7", "Distrito 5",3,95,R.drawable.cancha1));
        canchas.add(new Cancha(8, "Cancha 8", "Distrito 5",3,95,R.drawable.cancha1));
        canchas.add(new Cancha(9, "Cancha 9", "Distrito 5",3,95,R.drawable.cancha1));
        canchas.add(new Cancha(10, "Cancha 10", "Distrito 5",3,95,R.drawable.cancha1));
        canchas.add(new Cancha(11, "Cancha 11", "Distrito 5",3,95,R.drawable.cancha1));
        canchas.add(new Cancha(12, "Cancha 12", "Distrito 5",3,95,R.drawable.cancha1));
        return canchas;
    }
}
