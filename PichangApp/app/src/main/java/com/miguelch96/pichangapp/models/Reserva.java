package com.miguelch96.pichangapp.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private String cancha;
    private String direccion;

    public Reserva() {
    }

    public Reserva(int id, String fecha, String horas, String fechaSolicitud, String estado, String dia, String cancha, String direccion) {
        this.id = id;
        this.fecha = fecha;
        this.horas = horas;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
        this.dia = dia;
        this.cancha = cancha;
        this.direccion = direccion;
    }

    public Reserva(int id, String fecha, String horas, String fechaSolicitud, String estado, String dia) {
        this.id = id;
        this.fecha = fecha;
        this.horas = horas;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
        this.dia = dia;
    }

    public static List<Reserva> from(JSONArray jsonReservas) {
        List<Reserva> reservas = new ArrayList<>();
        try {
           for (int i = 0; i<jsonReservas.length();i++){
              JSONObject o = jsonReservas.getJSONObject(i);
              reservas.add(new Reserva(o.getInt("reservaId"),o.getString("fecha"), o.getString("horas"),o.getString("fechaSolicitud"),o.getString("estado"),o.getString("dia"),o.getString("nombreCancha"),"direccion"));
           }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return reservas;
    }

    public String getCancha() {
        return cancha;
    }

    public void setCancha(String cancha) {
        this.cancha = cancha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
