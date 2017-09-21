package com.miguelch96.pichangapp.models;

import android.os.Bundle;

/**
 * Created by Miguel on 9/20/2017.
 */

public class Cancha {
    public static final String CANCHAID = "canchaid";
    public static final String NOMBRE = "nombre";
    public static final String DISTRITO = "distrito";
    public static final String CALIFICACION = "calificacion";
    public static final String PRECIO = "precio";
    public static final String PICTUREID = "pictureid";


    private int CanchaId;
    private String Nombre;
    private String Distrito;
    private int Calificacion;
    private int Precio;
    private int PictureId;

    public Cancha() {
    }

    public Cancha(int canchaId, String nombre, String distrito, int calificacion, int precio, int pictureId) {
        CanchaId = canchaId;
        Nombre = nombre;
        Distrito = distrito;
        Calificacion = calificacion;
        Precio = precio;
        setPictureId(pictureId);
    }

    public int getCanchaId() {
        return CanchaId;
    }

    public Cancha setCanchaId(int canchaId) {
        CanchaId = canchaId;
        return this;
    }

    public String getNombre() {
        return Nombre;
    }

    public Cancha setNombre(String nombre) {
        Nombre = nombre;
        return this;
    }

    public String getDistrito() {
        return Distrito;
    }

    public Cancha setDistrito(String distrito) {
        Distrito = distrito;
        return this;
    }

    public int getCalificacion() {
        return Calificacion;
    }

    public Cancha setCalificacion(int calificacion) {
        Calificacion = calificacion;
        return this;
    }

    public int getPrecio() {
        return Precio;
    }

    public Cancha setPrecio(int precio) {
        Precio = precio;
        return this;
    }

    public int getPictureId() {
        return PictureId;
    }

    public Cancha setPictureId(int pictureId) {
        PictureId = pictureId;
        return this;
    }

    public Bundle toBundle(){
        Bundle bundle=new Bundle();
        bundle.putInt(CANCHAID,CanchaId);
        bundle.putString(NOMBRE,Nombre);
        bundle.putString(DISTRITO,Distrito);
        bundle.putInt(CALIFICACION,Calificacion);
        bundle.putInt(PRECIO,Precio);
        bundle.putInt(PICTUREID,PictureId);
        return bundle;
    }

    public static Cancha from(Bundle bundle){
        Cancha cancha=new Cancha();
        cancha.setCanchaId(bundle.getInt(CANCHAID))
                .setNombre(bundle.getString(NOMBRE))
                .setDistrito(bundle.getString(DISTRITO))
                .setCalificacion(bundle.getInt(CALIFICACION))
                .setPrecio(bundle.getInt(PRECIO))
                .setPictureId(bundle.getInt(PICTUREID));

        return cancha;
    }


}


