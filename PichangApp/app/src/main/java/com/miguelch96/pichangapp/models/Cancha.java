package com.miguelch96.pichangapp.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Miguel on 9/20/2017.
 */

public class Cancha implements Serializable {


    private int id;
    private String nombre;
    private String distrito;
    private int score;
    private Map<String, Double> precios;
    private String pictureUrl;
    private List<String> pictures;
    private List<Comentario> comentarios;
    private List<Skill> indicadores;
    private String material;
    private List<String> detalles;
    private String direccion;


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
        try {
            cancha.setId(jsonCancha.getInt("canchaId"));
            cancha.setNombre(jsonCancha.getString("nombre"));
            cancha.setDireccion(jsonCancha.getJSONObject("establecimiento").getString("direccion"));
            cancha.setMaterial(jsonCancha.getJSONObject("tipoSuperficie").getString("nombre"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return cancha;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Map<String, Double> getPrecios() {
        return precios;
    }

    public void setPrecios(Map<String, Double> precios) {
        this.precios = precios;
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

    public List<Skill> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(List<Skill> indicadores) {
        this.indicadores = indicadores;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public List<String> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<String> detalles) {
        this.detalles = detalles;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Cancha() {
    }

}


