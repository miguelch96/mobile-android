package com.miguelch96.pichangapp.models;

import java.io.Serializable;

/**
 * Created by Sergio on 29/10/2017.
 */

public class Comentario implements Serializable {

    private String comentario;
    private Double calificacion;
    private String usuario;
    private String urlImageUsuario;

    public Comentario(String comentario, Double calificacion, String usuario, String urlImageUsuario) {
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.usuario = usuario;
        this.urlImageUsuario = urlImageUsuario;
    }

    public Comentario() {
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUrlImageUsuario() {
        return urlImageUsuario;
    }

    public void setUrlImageUsuario(String urlImageUsuario) {
        this.urlImageUsuario = urlImageUsuario;
    }
}
