package com.miguelch96.pichangapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.miguelch96.pichangapp.fragments.cancha.CanchaFavoritesFragment;
import com.miguelch96.pichangapp.fragments.equipo.EquipoFavoritesFragment;
import com.miguelch96.pichangapp.fragments.equipo.RetosEnviadosFragment;

/**
 * Created by Sergio on 19/10/2017.
 */

public class FavoritesPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public FavoritesPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                CanchaFavoritesFragment tab1 = new CanchaFavoritesFragment();
                return tab1;
            case 1:
                EquipoFavoritesFragment tab2 = new EquipoFavoritesFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }


}
