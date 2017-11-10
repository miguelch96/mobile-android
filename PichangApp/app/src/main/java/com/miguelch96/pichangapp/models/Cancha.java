package com.miguelch96.pichangapp.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miguel on 9/20/2017.
 */

public class Cancha implements Serializable {


    private int id;
    private String nombre;
    private String descripcion;
    private String distrito;
    private double score;
    private Double precio;
    private String pictureUrl;
    private List<String> pictures;
    private List<Comentario> comentarios;
    private List<Skill> servicios;
    private String material;
    private String direccion;
    private List<Reserva> reservas;

    public Cancha() {
    }


    public static List<Cancha> from(JSONArray jsonCanchas) {
        List<Cancha> canchas = new ArrayList<>();
        for (int i = 0; i < jsonCanchas.length(); i++) {
            try {
                canchas.add(from(jsonCanchas.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return canchas;
    }

    public static Cancha from(JSONObject jsonCancha) {

        Cancha cancha = new Cancha();
        List<String> pictures = new ArrayList<>();
        List<Skill> servicios = new ArrayList<>();
        List<Comentario> comentarios = new ArrayList<>();
        List<Reserva> reservas = new ArrayList<>();


        try {
            cancha.setId(jsonCancha.getInt("canchaId"));
            cancha.setNombre(jsonCancha.getString("nombre"));
            cancha.setDireccion(jsonCancha.getString("direccion"));
            cancha.setMaterial(jsonCancha.getString("nombreTipoSuperficie"));
            cancha.setDistrito(jsonCancha.getString("nombreDistrito"));
            cancha.setPictureUrl(jsonCancha.getString("imagenPortadaUrl"));
            cancha.setScore(jsonCancha.getDouble("calificacion"));
            cancha.setPrecio(jsonCancha.getDouble("precio"));
            cancha.setDescripcion(jsonCancha.getString("descripcion"));

            JSONArray jsonPictures= jsonCancha.getJSONArray("imagenes");
            for (int i = 0; i <jsonPictures.length(); i++)
            {
                JSONObject picture = jsonPictures.getJSONObject(i);
                pictures.add(picture.getString("imagenUrl"));
            }
            cancha.setPictures(pictures);

            JSONArray jsonServicios= jsonCancha.getJSONArray("servicios");
            for (int i = 0; i <jsonServicios.length(); i++)
            {
                JSONObject servicio = jsonServicios.getJSONObject(i);
                servicios.add(new Skill(servicio.getString("nombre"),servicio.getString("imgServicioUrl"),0));
            }
            cancha.setServicios(servicios);

            JSONArray jsonComentarios= jsonCancha.getJSONArray("comentarios");
            for (int i = 0; i <jsonComentarios.length(); i++)
            {
                JSONObject comentario = jsonComentarios.getJSONObject(i);
                comentarios.add(new Comentario(comentario.getString("comentario"), comentario.getDouble("calificacion"),comentario.getString("nombreUsuario"),comentario.getString("imagenPerfilUrl")));
            }
            cancha.setComentarios(comentarios);

            JSONArray jsonReservas= jsonCancha.getJSONArray("reservasDisponibles");
            for (int i = 0; i <jsonReservas.length(); i++)
            {
                JSONObject reserva = jsonReservas.getJSONObject(i);
                reservas.add(new Reserva(reserva.getInt("reservaId"),reserva.getString("fecha"),reserva.getString("horas"),reserva.getString("fechaSolicitud"),reserva.getString("estado"),reserva.getString("dia")));
            }
            cancha.setReservas(reservas);


        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return cancha;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Skill> getServicios() {
        return servicios;
    }

    public void setServicios(List<Skill> servicios) {
        this.servicios = servicios;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}


