package com.miguelch96.pichangapp.models;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
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
    private List<Reto> retosEnviados;
    private List<Reto> retosRecibidos;
    private List<Reto> retosAceptados;

    //falta en el api
    private String distrito;
    private String categoria;
    private List<Comentario> comentarios;

    private List<Skill> skills; //el api da la lista de skills mas no lo principal, el puntaje
    private List<String> pictures;
    private double score;
    private String urlPicture;
    Map<String, String> integrantes = new HashMap<String, String>();//el api da solo los nombres de los integrantes

    public Equipo() {
    }


    public static Equipo from(JSONObject jsonEquipo) {

        Map<String, String> miembros = new HashMap<>();
        List<Comentario> coments = new ArrayList<>();
        List<String> pictures = new ArrayList<>();
        List<Skill> skills = new ArrayList<>();
        List<Reto> retEnviados = new ArrayList<>();
        List<Reto> retRecibidos = new ArrayList<>();
        List<Reto> retAceptados = new ArrayList<>();

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
            JSONArray jsonPictures= jsonEquipo.getJSONArray("imagenes");
            for (int i = 0; i <jsonPictures.length(); i++)
            {
                JSONObject picture = jsonPictures.getJSONObject(i);
                pictures.add(picture.getString("imagenUrl"));
            }

            JSONArray jsonSkills= jsonEquipo.getJSONArray("skills");
            for (int i = 0; i <jsonSkills.length(); i++)
            {
                JSONObject skill = jsonSkills.getJSONObject(i);
                skills.add(new Skill(skill.getString("nombre"), skill.getString("imagenSkillUrl"),skill.getInt("cantidad")));
            }

            JSONObject jsonRetos= jsonEquipo.getJSONObject("retos");
            JSONArray enviados = jsonRetos.getJSONArray("enviados");
            for (int i = 0; i <enviados.length(); i++)
            {
                JSONObject e = enviados.getJSONObject(i);
                if(e.getString("estado").equalsIgnoreCase("aceptado")) {
                    retAceptados.add(new Reto(e.getInt("retoId"),e.getInt("equipoRetadoId"),e.getInt("equipoRetadorId"),e.getString("fechaEncuentro"),e.getInt("canchaId"),e.getString("estado"),e.getString("equipoRetado"),e.getString("cancha")));
                }
                else if(e.getString("estado").equalsIgnoreCase("pendiente")){
                    retEnviados.add(new Reto(e.getInt("retoId"),e.getInt("equipoRetadoId"),e.getInt("equipoRetadorId"),e.getString("fechaEncuentro"),e.getInt("canchaId"),e.getString("estado"),e.getString("equipoRetado"),e.getString("cancha")));
                }
                 }

            JSONArray recibidos = jsonRetos.getJSONArray("recibidos");
            for (int i = 0; i <recibidos.length(); i++)
            {
                JSONObject e = recibidos.getJSONObject(i);
                if(e.getString("estado").equalsIgnoreCase("aceptado")) {
                    retAceptados.add(new Reto(e.getInt("retoId"),e.getInt("equipoRetadoId"),e.getInt("equipoRetadorId"),e.getString("fechaEncuentro"),e.getInt("canchaId"),e.getString("estado"),e.getString("equipoRetado"),e.getString("cancha")));
                }
                else if(e.getString("estado").equalsIgnoreCase("pendiente")){
                    retRecibidos.add(new Reto(e.getInt("retoId"),e.getInt("equipoRetadoId"),e.getInt("equipoRetadorId"),e.getString("fechaEncuentro"),e.getInt("canchaId"),e.getString("estado"),e.getString("equipoRetado"),e.getString("cancha")));
                }
            }

            equipo.setRetosAceptados(retAceptados);
            equipo.setRetosEnviados(retEnviados);
            equipo.setRetosRecibidos(retRecibidos);
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

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
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

    public List<Reto> getRetosAceptados() {
        return retosAceptados;
    }

    public void setRetosAceptados(List<Reto> retosAceptados) {
        this.retosAceptados = retosAceptados;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<Reto> getRetosEnviados() {
        return retosEnviados;
    }

    public void setRetosEnviados(List<Reto> retosEnviados) {
        this.retosEnviados = retosEnviados;
    }

    public List<Reto> getRetosRecibidos() {
        return retosRecibidos;
    }

    public void setRetosRecibidos(List<Reto> retosRecibidos) {
        this.retosRecibidos = retosRecibidos;
    }
}
