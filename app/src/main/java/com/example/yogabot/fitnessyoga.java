package com.example.yogabot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class fitnessyoga extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitnessyoga);


    }


    public void tadasana_ocl(View view) {
        Intent intent = new Intent(fitnessyoga.this, phalakasana_pose.class);
        startActivity(intent);
    }

    public void virabhadrasana_ocl(View view) {
        Intent intent = new Intent(fitnessyoga.this, virabhadrasana_pose.class);
        startActivity(intent);
    }

    public void vrkasana_ocl(View view) {
        Intent intent = new Intent(fitnessyoga.this, virkshasana_pose.class);
        startActivity(intent);
    }

    public void trikonasana_ocl(View view) {
        Intent intent = new Intent(fitnessyoga.this, trikonasana_pose.class);
        startActivity(intent);
    }

    public void bhujangasana_ocl(View view) {
        Intent intent = new Intent(fitnessyoga.this, bharadavasana_pose.class);
        startActivity(intent);
    }

    public void setuBandhaSarvangasana_ocl(View view) {
        Intent intent = new Intent(fitnessyoga.this, setu_bandhasana_pose.class);
        startActivity(intent);
    }

    public void paschimottasana_ocl(View view) {
        Intent intent = new Intent(fitnessyoga.this, pashimottanasana.class);
        startActivity(intent);
    }
}