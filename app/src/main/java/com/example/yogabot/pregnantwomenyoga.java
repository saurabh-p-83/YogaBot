package com.example.yogabot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class pregnantwomenyoga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnantwomenyoga);
    }

    public void trikonasana_ocl(View view) {
        Intent intent = new Intent(pregnantwomenyoga.this, trikonasana_pose.class);
        startActivity(intent);
    }

    public void bhardvajasana_ocl(View view) {
        Intent intent = new Intent(pregnantwomenyoga.this, bharadavasana_pose.class);
        startActivity(intent);
    }

    public void adhoMukhaSvanasana_ocl(View view) {
        Intent intent = new Intent(pregnantwomenyoga.this, adhoMuthaSvanasana_pose.class);
        startActivity(intent);
    }

    public void salabhasana_ocl(View view) {
        Intent intent = new Intent(pregnantwomenyoga.this, salabhasana_pose.class);
        startActivity(intent);
    }

    public void tadasana_ocl(View view) {
        Intent intent = new Intent(pregnantwomenyoga.this, tadasana_pose.class);
        startActivity(intent);
    }

    public void savasana_ocl(View view) {
        Intent intent = new Intent(pregnantwomenyoga.this, shavasana_pose.class);
        startActivity(intent);
    }

    public void baddhaKonsana_ocl(View view) {
        Intent intent = new Intent(pregnantwomenyoga.this, badhhaKonsana_pose.class);
        startActivity(intent);
    }
}