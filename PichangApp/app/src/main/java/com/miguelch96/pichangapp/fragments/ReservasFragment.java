package com.miguelch96.pichangapp.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.adapters.ReservaPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReservasFragment extends Fragment {


    public ReservasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_reservas, container, false);


        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_reservas_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Reservas"));
        tabLayout.addTab(tabLayout.newTab().setText("Partidos"));
        tabLayout.addTab(tabLayout.newTab().setText("Retos enviados"));
        tabLayout.addTab(tabLayout.newTab().setText("Retos recibidos"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.reservas_pager);
        final ReservaPagerAdapter adapter = new ReservaPagerAdapter
                (getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }



            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }
    }

