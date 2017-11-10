package com.miguelch96.pichangapp.models;

import java.io.Serializable;

/**
 * Created by Sergio on 08/11/2017.
 */

public class Reserva implements Serializable {

    private int id;
    private String fecha;
    private String horas;
    private String fechaSolicitud;
    private String estado;
    private String dia;

    public Reserva() {
    }

    public Reserva(int id, String fecha, String horas, String fechaSolicitud, String estado, String dia) {
        this.id = id;
        this.fecha = fecha;
        this.horas = horas;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
        this.dia = dia;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
