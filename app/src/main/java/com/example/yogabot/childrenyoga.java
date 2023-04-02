package com.example.yogabot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class childrenyoga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childrenyoga);
    }

    public void sukhasana_ocl(View view) {
        Intent intent = new Intent(childrenyoga.this, sukhasana_pose.class);
        startActivity(intent);
    }

    public void ardhaPadmasana_ocl(View view) {
        Intent intent = new Intent(childrenyoga.this, ardh_padmasana_pose.class);
        startActivity(intent);
    }

    public void balasana_ocl(View view) {
        Intent intent = new Intent(childrenyoga.this, balasana_pose.class);
        startActivity(intent);
    }

    public void bhujanagasana_ocl(View view) {
        Intent intent = new Intent(childrenyoga.this, bhujangasana_pose.class);
        startActivity(intent);
    }

    public void paschimottasana_ocl(View view) {
        Intent intent = new Intent(childrenyoga.this, pashimottanasana.class);
        startActivity(intent);
    }

    public void vrksasana_ocl(View view) {
        Intent intent = new Intent(childrenyoga.this, virkshasana_pose.class);
        startActivity(intent);
    }

    public void upvisthaKonsana_ocl(View view) {
        Intent intent = new Intent(childrenyoga.this, upavisthaKonsana_pose.class);
        startActivity(intent);
    }
}