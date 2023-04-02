package com.example.yogabot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sleepingimpromentyoga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleepingimpromentyoga);
    }

    public void uttanasana_ocl(View view) {
        Intent intent = new Intent(sleepingimpromentyoga.this, uttanasana_pose.class);
        startActivity(intent);
    }

    public void balasana_ocl(View view) {
        Intent intent = new Intent(sleepingimpromentyoga.this, balasana_pose.class);
        startActivity(intent);
    }

    public void ardhUttanasana_ocl(View view) {
        Intent intent = new Intent(sleepingimpromentyoga.this, ardhuttanasana_pose.class);
        startActivity(intent);
    }

    public void suptaBaddhaKonsana_ocl(View view) {
        Intent intent = new Intent(sleepingimpromentyoga.this, suptaBaddhaKonsana_pose.class);
        startActivity(intent);
    }

    public void viparitaKarani_ocl(View view) {
        Intent intent = new Intent(sleepingimpromentyoga.this, viprita_karani_pose.class);
        startActivity(intent);
    }

    public void savasana_ocl(View view) {
        Intent intent = new Intent(sleepingimpromentyoga.this, shavasana_pose.class);
        startActivity(intent);
    }
}