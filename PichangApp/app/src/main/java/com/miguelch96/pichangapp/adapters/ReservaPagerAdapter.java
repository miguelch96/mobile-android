package com.miguelch96.pichangapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.miguelch96.pichangapp.adapters.equipo.RetosRecibidosAdapter;
import com.miguelch96.pichangapp.fragments.cancha.ReservasCanchaFragment;
import com.miguelch96.pichangapp.fragments.equipo.ReservasEquipoFragment;
import com.miguelch96.pichangapp.fragments.equipo.retos.RetosEnviadosFragment;
import com.miguelch96.pichangapp.fragments.equipo.retos.RetosRecibidosFragment;

/**
 * Created by Sergio on 17/10/2017.
 */

public class ReservaPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public ReservaPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ReservasCanchaFragment tab1 = new ReservasCanchaFragment();
                return tab1;
            case 1:
                ReservasEquipoFragment tab2 = new ReservasEquipoFragment();
                return tab2;
            case 2:
                RetosEnviadosFragment tab3 = new RetosEnviadosFragment();
                return tab3;
            case 3:
                RetosRecibidosFragment tab4 = new RetosRecibidosFragment();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
