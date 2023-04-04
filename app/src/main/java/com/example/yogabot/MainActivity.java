package com.example.yogabot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the BottomNavigationView in the layout
        navigationView = findViewById(R.id.navigationBar1);

        // Set a listener for when items in the navigation bar are selected
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                // Determine which item in the navigation bar was selected and create a new fragment accordingly
                switch (item.getItemId()){
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.chatbot:
                        fragment = new chatbot();
                        break;
                    case R.id.dietplan:
                        fragment = new dietPlan();
                        break;
                    case R.id.profile:
                        fragment = new userProfile();
                        break;
                }

                // Replace the current fragment with the new fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView6 , fragment).commit();

                // Return true to indicate that the item selection was handled
                return true;
            }
        });
    }
}