package com.miguelch96.pichangapp.models;

import java.io.Serializable;

/**
 * Created by Sergio on 31/10/2017.
 */

public class Skill implements Serializable {

    private String nombre;
    private String imageUrl;
    private int cantidad;

    public Skill() {
    }

    public Skill(String nombre, String imageUrl, int cantidad) {
        this.nombre = nombre;
        this.imageUrl = imageUrl;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
