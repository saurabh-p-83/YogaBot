package com.example.yogabot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class registerLogin extends AppCompatActivity {
    Button sign_UP_button,login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_login);
        login_button = findViewById(R.id.login_button);
        sign_UP_button = findViewById(R.id.sign_UP_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registerLogin.this, login.class);
                startActivity(intent);
            }
        });
        sign_UP_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registerLogin.this, signup.class);
                startActivity(intent);
            }
        });
    }
}