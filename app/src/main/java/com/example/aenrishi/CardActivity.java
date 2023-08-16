package com.example.aenrishi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_activity);

        BottomNavigationView bottomNavView = findViewById(R.id.nav_view);
        NavigationUtil.setupBottomNavView(bottomNavView, this, R.id.ic_card);
    }
}