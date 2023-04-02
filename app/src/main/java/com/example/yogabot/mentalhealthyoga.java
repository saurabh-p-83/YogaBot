package com.example.yogabot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mentalhealthyoga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentalhealthyoga);
    }

    public void bhramariPranayama_ocl(View view) {
        Intent intent = new Intent(mentalhealthyoga.this, bhramari_pranayama_pose.class);
        startActivity(intent);
    }

    public void balasana_ocl(View view) {
        Intent intent = new Intent(mentalhealthyoga.this, balasana_pose.class);
        startActivity(intent);
    }

    public void vipritakarani_ocl(View view) {
        Intent intent = new Intent(mentalhealthyoga.this, viprita_karani_pose.class);
        startActivity(intent);
    }

    public void uttanasana_ocl(View view) {
        Intent intent = new Intent(mentalhealthyoga.this, uttanasana_pose.class);
        startActivity(intent);
    }

    public void shavasana_ocl(View view) {
        Intent intent = new Intent(mentalhealthyoga.this, shavasana_pose.class);
        startActivity(intent);
    }
}