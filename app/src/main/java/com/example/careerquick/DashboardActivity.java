package com.example.careerquick;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import Fragments.HomeFragment;
import Fragments.JobFragment;
import Fragments.LearnFragment;
import Fragments.ProfileFragment;

public class DashboardActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ImageView menuIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize views
        bottomNavigationView = findViewById(R.id.bottom_nav);
        menuIcon = findViewById(R.id.menu_icon);

        // Set bottom navigation item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        // Set click listener for the menu icon to open the navigation drawer
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        // Set the HomeFragment as the default fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    // Handle navigation item clicks using if-else statements
                    if (item.getItemId() == R.id.navigation_item_1) {
                        selectedFragment = new HomeFragment();
                    } else if (item.getItemId() == R.id.navigation_item_2) {
                        selectedFragment = new JobFragment();
                    } else if (item.getItemId() == R.id.navigation_item_3) {
                        selectedFragment = new LearnFragment();
                    } else if (item.getItemId() == R.id.navigation_item_4) {
                        selectedFragment = new ProfileFragment();
                    }

                    // Replace the current fragment with the selected one
                    if (selectedFragment != null) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, selectedFragment).commit();
                        return true;
                    } else {
                        return false;
                    }
                }
            };
}
