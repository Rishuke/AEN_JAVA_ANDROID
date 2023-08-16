package com.example.aenrishi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountActivity extends AppCompatActivity {

    private Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        BottomNavigationView bottomNavView = findViewById(R.id.nav_view);
        NavigationUtil.setupBottomNavView(bottomNavView, this, R.id.ic_account);

        // Find the logout button
        btn_logout = findViewById(R.id.btn_logout);  // Assurez-vous que l'ID est correct

        // Set an onClickListener on the logout button
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });
    }

    private void logoutUser() {
        // If you have stored user data in SharedPreferences or any local storage, clear it.
        // For example:
        // SharedPreferences preferences = getSharedPreferences("userPrefs", MODE_PRIVATE);
        // SharedPreferences.Editor editor = preferences.edit();
        // editor.clear();
        // editor.apply();
        Toast.makeText(AccountActivity.this, "Deconnexion réussie", Toast.LENGTH_SHORT).show();
        // Redirect the user to the login activity or any other starting activity
        Intent intent = new Intent(AccountActivity.this, MainActivity.class);
        // Assuming LoginActivity is the name of your login activity

        // Clear the activity stack to ensure the user cannot navigate back
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(intent);
        finish();  // This will close the current activity
    }
}
