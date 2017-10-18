package com.miguelch96.pichangapp.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.fragments.CanchasFragment;
import com.miguelch96.pichangapp.fragments.EquiposFragment;
import com.miguelch96.pichangapp.fragments.HomeFragment;
import com.miguelch96.pichangapp.fragments.ReservasFragment;

public class MainActivity extends AppCompatActivity{

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return navigateAccordingTo(item.getItemId());
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigateAccordingTo(R.id.action_home);
    }


    private Fragment getFragmentFor(int id){
        switch (id){
            case R.id.action_home:
                return new HomeFragment();
            case R.id.action_team:
                return new EquiposFragment();
            case R.id.action_reservas:
                return new ReservasFragment();
        }
        return null;
    }

    private boolean navigateAccordingTo(int id){
        try {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content,getFragmentFor(id))
                    .commit();

            return true;

        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }
}
