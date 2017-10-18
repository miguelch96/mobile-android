package com.miguelch96.pichangapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.miguelch96.pichangapp.fragments.CanchasFragment;
import com.miguelch96.pichangapp.fragments.EquiposFragment;

/**
 * Created by Sergio on 14/10/2017.
 */

public class HomePagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public HomePagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                CanchasFragment tab1 = new CanchasFragment();
                return tab1;
            case 1:
                EquiposFragment tab2 = new EquiposFragment();
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
