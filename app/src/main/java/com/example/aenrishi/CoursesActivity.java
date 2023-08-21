package com.example.aenrishi;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses); // Votre layout XML pour cette activité

        BottomNavigationView bottomNavView = findViewById(R.id.nav_view);
        NavigationUtil.setupBottomNavView(bottomNavView, this, R.id.ic_courses);



        // Récupérez une référence à vos boutons
        Button btn1 = findViewById(R.id.btn_1);
        Button btn2 = findViewById(R.id.btn_2);
        Button btn3 = findViewById(R.id.btn_3);

        // Ajoutez un auditeur de clic à chaque bouton
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToQcmList();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToQcmList();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToQcmList();
            }
        });
    }

    // Cette fonction démarre votre activité activity_qcm_list
    private void navigateToQcmList() {
        Intent intent = new Intent(CoursesActivity.this, QcmListActivity.class); // Remplacez QcmListActivity par le nom exact de votre activité
        startActivity(intent);
    }
}
