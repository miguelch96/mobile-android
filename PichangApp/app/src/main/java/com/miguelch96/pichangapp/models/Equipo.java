package com.miguelch96.pichangapp.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sergio on 26/09/2017.
 */

public class Equipo implements Serializable {

    private int EquipoId;
    private String nombre;
    private String distrito;
    private String categoria;
    private List<String> comentarios;
    private List<Double> skills;
    private List<Integer> pictures;
    private double score;
    private int picture;
    Map<String, Integer> integrantes = new HashMap<String,Integer>();

    public Equipo() {
    }

    public Equipo(int equipoId, String nombre, String distrito, String categoria, List<String> comentarios, List<Double> skills, List<Integer> pictures, double score, int picture, Map<String, Integer> integrantes) {
        EquipoId = equipoId;
        this.nombre = nombre;
        this.distrito = distrito;
        this.categoria = categoria;
        this.comentarios = comentarios;
        this.skills = skills;
        this.pictures = pictures;
        this.score = score;
        this.picture = picture;
        this.integrantes = integrantes;
    }

    public Map<String, Integer> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(Map<String, Integer> integrantes) {
        this.integrantes = integrantes;
    }

    public List<Integer> getPictures() {
        return pictures;
    }

    public void setPictures(List<Integer> pictures) {
        this.pictures = pictures;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public int getEquipoId() {
        return EquipoId;
    }

    public void setEquipoId(int equipoId) {
        EquipoId = equipoId;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }


    public List<Double> getSkills() {
        return skills;
    }

    public void setSkills(List<Double> skills) {
        this.skills = skills;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}