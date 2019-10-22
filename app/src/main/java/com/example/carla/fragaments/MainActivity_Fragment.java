package com.example.carla.fragaments;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity_Fragment extends AppCompatActivity implements
        FragmentOne.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__fragment);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentOne fragment = FragmentOne.newInstance();
        fragmentTransaction.add(R.id.fragmentOne, fragment);
        fragmentTransaction.commit();
    }



    @Override
    public void onFragmentInteraction(String text, int colorId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentTwo fragment = FragmentTwo.newInstance(text, colorId);
        fragmentTransaction.replace(R.id.fragmentTwo, fragment);
        fragmentTransaction.commit();
    }
}