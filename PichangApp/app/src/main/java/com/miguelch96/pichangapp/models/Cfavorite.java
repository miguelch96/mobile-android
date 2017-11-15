package com.miguelch96.pichangapp.models;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by Sergio on 14/11/2017.
 */

@Table
public class Cfavorite extends SugarRecord {

    public int canchaId;

    public Cfavorite() {
    }

    public Cfavorite(int canchaId) {
        this.canchaId = canchaId;
    }
}
