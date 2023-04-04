package com.example.yogabot;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set the layout for the splash screen
        setContentView(R.layout.activity_splashscreen);

        // create an intent to launch the next activity
        Intent iNext = new Intent(splashscreen.this, MainActivity.class);

        // delay the execution of the following code by 200 milliseconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // check if the user has logged in before
                SharedPreferences sharedPreferences = getSharedPreferences(login.PRFS_NAME, 0);
                boolean hasLoggedIn = sharedPreferences.getBoolean("hasLoggedIn", false);

                // if the user has logged in before, start the MainActivity and finish the splashscreen activity
                if(hasLoggedIn) {
                    startActivity(iNext);
                    finish();
                } else {
                    // if the user has not logged in before, start the registerLogin activity and finish the splashscreen activity
                    Intent iNext = new Intent(splashscreen.this, registerLogin.class);
                    startActivity(iNext);
                    finish();
                }
            }
        }, 200);
    }
}