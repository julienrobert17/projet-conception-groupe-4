package com.example.alclicker;

import android.content.Intent;
import android.os.Bundle;

import com.example.alclicker.ui.dashboard.DashboardFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    private int BestScore = 0;

    private int Id = 0;

    private String Pseudo = "";

    private String Arme = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        Intent myIntent = getIntent(); // gets the previously created intent

        Pseudo = myIntent.getStringExtra("pseudo");
        BestScore = myIntent.getIntExtra("best_score", 0);
        Id = myIntent.getIntExtra("id_user", -1);

        Arme = myIntent.getStringExtra("arme");

    }

    public int getScore(){
        return BestScore;
    }

    public int getIdUser(){
        return Id;
    }

    public String getPseudo(){
        return Pseudo;
    }

    public String getArme(){
        return Arme;
    }


}