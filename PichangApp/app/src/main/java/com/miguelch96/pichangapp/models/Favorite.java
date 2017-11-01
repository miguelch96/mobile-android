package com.miguelch96.pichangapp.models;

import com.orm.SugarRecord;



/**
 * Created by Sergio on 23/10/2017.
 */

public class Favorite extends SugarRecord {

    public int id;

    public Favorite() {
    }

    public Favorite(int id) {
        this.id = id;
    }


}
