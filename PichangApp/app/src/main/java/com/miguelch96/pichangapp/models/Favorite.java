package com.miguelch96.pichangapp.models;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by Sergio on 23/10/2017.
 */

public class Favorite extends SugarRecord {

    private Equipo equipo;

    public Favorite() {
    }

    public Favorite(Equipo equipo) {
        this.equipo = equipo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
