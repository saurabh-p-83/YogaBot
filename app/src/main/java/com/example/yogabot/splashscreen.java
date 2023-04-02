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
        setContentView(R.layout.activity_splashscreen);

        Intent iNext = new Intent(splashscreen.this, MainActivity.class );
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences(login.PRFS_NAME,0);
                boolean hasLoggedIn = sharedPreferences.getBoolean("hasLoggedIn",false);
                if(hasLoggedIn){
                    startActivity(iNext);
                    finish();
                }
                else{
                    Intent iNext = new Intent(splashscreen.this, login.class );
                    startActivity(iNext);
                    finish();
                }



            }
        },200);




    }
}