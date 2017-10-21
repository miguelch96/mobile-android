package com.miguelch96.pichangapp.models;

/**
 * Created by Sergio on 19/10/2017.
 */

public class Reto {

    private int id;
    private Equipo retado;
    private Equipo retador;
    private String fecha;
    private Cancha cancha;
    private String estado;

    public Reto(int id, Equipo retado, Equipo retador, String fecha, Cancha cancha, String estado) {
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

    public Equipo getRetado() {
        return retado;
    }

    public void setRetado(Equipo retado) {
        this.retado = retado;
    }

    public Equipo getRetador() {
        return retador;
    }

    public void setRetador(Equipo retador) {
        this.retador = retador;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
