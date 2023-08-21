package com.example.aenrishi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private int memberId;  // Remplacez par l'ID de l'utilisateur connecté

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        databaseHelper = new DatabaseHelper(this);

        BottomNavigationView bottomNavView = findViewById(R.id.nav_view);
        NavigationUtil.setupBottomNavView(bottomNavView, this, R.id.ic_home);

        bottomNavView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.ic_home) {
                    // Handle click on Home icon
                    return true;
                } else if (itemId == R.id.ic_courses) {
                    if (bottomNavView.getSelectedItemId() != R.id.ic_courses) {
                        Intent intent = new Intent(HomeActivity.this, CoursesActivity.class);
                        startActivity(intent);
                    }
                    return true;
                } else if (itemId == R.id.ic_card) {
                    // Handle click on Card icon
                    return true;
                } else if (itemId == R.id.ic_account) {
                    // Handle click on Account icon
                    return true;
                }
                return false;
            }
        });

    }
}
