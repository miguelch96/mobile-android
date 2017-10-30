package com.miguelch96.pichangapp.models;

import com.miguelch96.pichangapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sergio on 26/09/2017.
 */

public class Equipo implements Serializable {


    //en el api
    private int EquipoId;
    private String nombre;

    //falta en el api
    private String distrito;
    private String categoria;
    private List<Comentario> comentarios;

    private List<Double> skills; //el api da la lista de skills mas no lo principal, el puntaje
    private List<Integer> pictures;
    private double score;
    private String urlPicture;
    Map<String, String> integrantes = new HashMap<String, String>();//el api da solo los nombres de los integrantes

    public Equipo() {
    }

    public Equipo(int equipoId, String nombre, String distrito, String categoria, List<Comentario> comentarios, List<Double> skills, List<Integer> pictures, double score, String picture, Map<String, String> integrantes) {
        EquipoId = equipoId;
        this.nombre = nombre;
        this.distrito = distrito;
        this.categoria = categoria;
        this.comentarios = comentarios;
        this.skills = skills;
        this.pictures = pictures;
        this.score = score;
        this.urlPicture = picture;
        this.integrantes = integrantes;
    }

    public static Equipo from(JSONObject jsonEquipo) {

        Map<String, String> miembros = new HashMap<>();
        List<Comentario> coments = new ArrayList<>();

        List<Integer> pictures = new ArrayList<>();
        pictures.add(R.drawable.pic1);
        pictures.add(R.drawable.pic2);
        pictures.add(R.drawable.pic3);

        List<Double> skills = new ArrayList<>();
        skills.add(3.4);
        skills.add(4.0);
        skills.add(2.8);

        Equipo equipo = new Equipo();
        try {

            equipo.setEquipoId(jsonEquipo.getInt("equipoId"));
            equipo.setNombre(jsonEquipo.getString("nombre"));

            equipo.setCategoria(jsonEquipo.getJSONObject("categoria").getString("nombre"));
            equipo.setDistrito(jsonEquipo.getJSONObject("distrito").getString("nombre"));


            JSONArray jsonMiembros = jsonEquipo.getJSONArray("miembros");
            for (int i = 0; i <jsonMiembros.length(); i++)
            {
                JSONObject miembro = jsonMiembros.getJSONObject(i);
                miembros.put(miembro.getString("nombre") +" "+ miembro.getString("apellido"),miembro.getString("imagenPerfilUrl"));
            }

            JSONArray jsonComents = jsonEquipo.getJSONArray("comentarios");
            for (int i = 0; i <jsonComents.length(); i++)
            {
                JSONObject coment = jsonComents.getJSONObject(i);
                coments.add(new Comentario(coment.getString("comentario") ,coment.getDouble("calificacion"),coment.getString("nombreUsuario"),coment.getString("imagenPerfilUrl")));
            }
            equipo.setIntegrantes(miembros);
            equipo.setUrlPicture(jsonEquipo.getString("imagenPortadaUrl"));
            equipo.setPictures(pictures);
            equipo.setScore(jsonEquipo.getDouble("calificacion"));
            equipo.setSkills(skills);
            equipo.setComentarios(coments);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return equipo;
    }


    public static List<Equipo> from(JSONArray jsonEquipos) {
        List<Equipo> equipos = new ArrayList<>();
        for (int i = 0; i < jsonEquipos.length(); i++) {
            try {
                equipos.add(from(jsonEquipos.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return equipos;
    }

    public Map<String, String> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(Map<String, String> integrantes) {
        this.integrantes = integrantes;
    }

    public List<Integer> getPictures() {
        return pictures;
    }

    public void setPictures(List<Integer> pictures) {
        this.pictures = pictures;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
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

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
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
