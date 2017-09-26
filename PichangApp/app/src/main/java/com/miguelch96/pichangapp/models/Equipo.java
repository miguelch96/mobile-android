package com.miguelch96.pichangapp.models;

import java.util.List;

/**
 * Created by Sergio on 26/09/2017.
 */

public class Equipo {

    private int EquipoId;
    private String nombre;
    private String distrito;
    private String categoria;
    private List<String> comentarios;
    private List<String> integrantes;
    private List<Integer> skills;
    private double score;
    private int picture;

    public Equipo() {
    }

    public Equipo(int equipoId, String nombre, String distrito, String categoria, List<String> comentarios, List<String> integrantes, List<Integer> skills, double score, int picture) {
        EquipoId = equipoId;
        this.nombre = nombre;
        this.distrito = distrito;
        this.categoria = categoria;
        this.comentarios = comentarios;
        this.integrantes = integrantes;
        this.skills = skills;
        this.score = score;
        this.picture = picture;
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

    public List<String> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<String> integrantes) {
        this.integrantes = integrantes;
    }

    public List<Integer> getSkills() {
        return skills;
    }

    public void setSkills(List<Integer> skills) {
        this.skills = skills;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
