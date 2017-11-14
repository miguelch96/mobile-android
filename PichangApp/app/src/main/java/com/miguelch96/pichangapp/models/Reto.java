package com.miguelch96.pichangapp.models;

import java.io.Serializable;

/**
 * Created by Sergio on 19/10/2017.
 */

public class Reto implements Serializable {

    private int id;
    private int retadoId;
    private int retadorId;
    private String fecha;
    private int canchaId;
    private String estado;
    private String nombreRival;
    private String nombreCancha;

    public Reto(int id, int retado, int retador, String fecha, int cancha, String estado, String nombreRival, String nombreCancha) {
        this.id = id;
        this.retadoId = retado;
        this.retadorId = retador;
        this.fecha = fecha;
        this.canchaId = cancha;
        this.estado = estado;
        this.nombreRival = nombreRival;
        this.nombreCancha = nombreCancha;
    }

    public Reto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRetadoId() {
        return retadoId;
    }

    public void setRetadoId(int retadoId) {
        this.retadoId = retadoId;
    }

    public int getRetadorId() {
        return retadorId;
    }

    public void setRetadorId(int retadorId) {
        this.retadorId = retadorId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCanchaId() {
        return canchaId;
    }

    public void setCanchaId(int canchaId) {
        this.canchaId = canchaId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreRival() {
        return nombreRival;
    }

    public void setNombreRival(String nombreRival) {
        this.nombreRival = nombreRival;
    }

    public String getNombreCancha() {
        return nombreCancha;
    }

    public void setNombreCancha(String nombreCancha) {
        this.nombreCancha = nombreCancha;
    }
}
