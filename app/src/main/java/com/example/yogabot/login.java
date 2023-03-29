package com.example.yogabot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUsernameEditText = findViewById(R.id.username_input);
        mPasswordEditText = findViewById(R.id.password_input);
        Button loginButton = findViewById(R.id.login_button);
        DB = new DBHelper(this);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mUsernameEditText.getText().toString().trim();
                String password = mPasswordEditText.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mUsernameEditText.setError("Please enter your email");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    mPasswordEditText.setError("Please enter your password");
                    return;
                }

                // Perform the authentication check
                Boolean checkUserCredential = DB.checkuserEmailpassword(email,password);
                if (checkUserCredential == true) {
                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // Failed login, display error message
                    Toast.makeText(getApplicationContext(), "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView forgotPasswordText = findViewById(R.id.forgot_password_text);
        forgotPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle forgot password click
                Toast.makeText(login.this, "Forgot password clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

}


