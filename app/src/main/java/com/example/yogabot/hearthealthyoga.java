package com.example.yogabot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class hearthealthyoga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hearthealthyoga);
    }

    public void vrikshasana_ocl(View view) {
        Intent intent = new Intent(hearthealthyoga.this, virkshasana_pose.class);
        startActivity(intent);
    }

    public void utthitaHastapadasana_ocl(View view) {
        Intent intent = new Intent(hearthealthyoga.this, utthita_hastapadasana_pose.class);
        startActivity(intent);
    }

    public void uttanasana_ocl(View view) {
        Intent intent = new Intent(hearthealthyoga.this, uttanasana_pose.class);
        startActivity(intent);
    }

    public void padungasthasana_ocl(View view) {
        Intent intent = new Intent(hearthealthyoga.this, padungashtasana_pose.class);
        startActivity(intent);
    }

    public void tadasana_ocl(View view) {
        Intent intent = new Intent(hearthealthyoga.this, tadasana_pose.class);
        startActivity(intent);
    }
}