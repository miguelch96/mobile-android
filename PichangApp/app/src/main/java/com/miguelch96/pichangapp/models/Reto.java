package com.miguelch96.pichangapp.models;

import java.io.Serializable;

/**
 * Created by Sergio on 19/10/2017.
 */

public class Reto implements Serializable {

    private int id;
    private int retado;
    private int retador;
    private String fecha;
    private int cancha;
    private String estado;

    public Reto(int id, int retado, int retador, String fecha, int cancha, String estado) {
        this.id = id;
        this.retado = retado;
        this.retador = retador;
        this.fecha = fecha;
        this.cancha = cancha;
        this.estado = estado;
    }


    public Reto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRetado() {
        return retado;
    }

    public void setRetado(int retado) {
        this.retado = retado;
    }

    public int getRetador() {
        return retador;
    }

    public void setRetador(int retador) {
        this.retador = retador;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCancha() {
        return cancha;
    }

    public void setCancha(int cancha) {
        this.cancha = cancha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
