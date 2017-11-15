package com.miguelch96.pichangapp.models;

import com.orm.SugarRecord;
import com.orm.dsl.Table;
import com.orm.dsl.Unique;


/**
 * Created by Sergio on 23/10/2017.
 */
@Table
public class Favorite extends SugarRecord {


    public int equipoId;

    public Favorite() {
    }

    public Favorite(int equipoId) {
        this.equipoId = equipoId;
    }



}
