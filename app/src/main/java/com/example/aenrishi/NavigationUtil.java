package com.example.aenrishi;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class NavigationUtil {
    public static void setupBottomNavView(BottomNavigationView bottomNavView, final Context context, int currentActivityId) {
        bottomNavView.setSelectedItemId(currentActivityId);
        bottomNavView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.ic_home) {
                    if (currentActivityId != R.id.ic_home) {
                        context.startActivity(new Intent(context, HomeActivity.class));
                    }
                } else if (itemId == R.id.ic_courses) {
                    if (currentActivityId != R.id.ic_courses) {
                        context.startActivity(new Intent(context, CoursesActivity.class));
                    }
                } else if (itemId == R.id.ic_card) {
                    if (currentActivityId != R.id.ic_card) {
                        context.startActivity(new Intent(context, CardActivity.class));
                    }
                } else if (itemId == R.id.ic_account) {
                    if (currentActivityId != R.id.ic_account) {
                        context.startActivity(new Intent(context, AccountActivity.class));
                    }
                }
                return true;
            }
        });
    }
}

