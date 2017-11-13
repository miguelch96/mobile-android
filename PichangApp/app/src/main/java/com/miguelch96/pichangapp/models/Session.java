package com.miguelch96.pichangapp.models;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Sergio on 09/11/2017.
 */

public class Session implements Serializable {

private Equipo equipo;

    public Session() {
    }

    public  Equipo getSession() {
equipo = new Equipo();

        AndroidNetworking.get("http://miguelch96-001-site1.itempurl.com/api/equipos/1")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                          equipo = Equipo.from(response.getJSONObject("equipo"));


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                    }
                });
        return equipo;
    }
}
