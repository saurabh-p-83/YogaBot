package com.example.yogabot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
    public static String PRFS_NAME = "MyPrefsFile";
    DBHelper DB;


    @Override
    // This is the method called when the activity is created.
// It is responsible for setting up the UI and handling user input.
    protected void onCreate(Bundle savedInstanceState) {
        // Call the parent class's implementation of onCreate
        super.onCreate(savedInstanceState);

        // Set the layout for this activity to the specified layout file
        setContentView(R.layout.activity_login);

        // Get references to the username and password EditText fields
        mUsernameEditText = findViewById(R.id.username_input);
        mPasswordEditText = findViewById(R.id.password_input);

        // Get a reference to the login button
        Button loginButton = findViewById(R.id.login_button);

        // Create a new instance of the DBHelper class to access the database
        DB = new DBHelper(this);

        // Set up an OnClickListener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get a reference to the SharedPreferences object for this app
                SharedPreferences sharedPreferences = getSharedPreferences(login.PRFS_NAME, 0);

                // Save a boolean value indicating that the user has logged in
                sharedPreferences.edit().putBoolean("hasLoggedIn", true).commit();

                // Get the user's email and password from the EditText fields
                String email = mUsernameEditText.getText().toString().trim();
                String password = mPasswordEditText.getText().toString().trim();

                // If the email field is empty, display an error and return
                if (TextUtils.isEmpty(email)) {
                    mUsernameEditText.setError("Please enter your email");
                    return;
                }

                // If the password field is empty, display an error and return
                if (TextUtils.isEmpty(password)) {
                    mPasswordEditText.setError("Please enter your password");
                    return;
                }

                // Perform an authentication check using the email and password
                Boolean checkUserCredential = DB.checkuserEmailpassword(email,password);
                if (checkUserCredential == true) {
                    // If the authentication check succeeds, display a success message and start the MainActivity
                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // If the authentication check fails, display an error message
                    Toast.makeText(getApplicationContext(), "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Get a reference to the "Forgot Password" TextView
        TextView forgotPasswordText = findViewById(R.id.forgot_password_text);

        // Set up an OnClickListener for the "Forgot Password" TextView
        forgotPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the "Forgot Password" click by displaying a message
                Toast.makeText(login.this, "Forgot password clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // This method is called when the "Sign Up" button is clicked
    public void signin_signup(View view) {
        // Create an intent to start the signup activity
        Intent intent = new Intent(getBaseContext(), signup.class);

        // Start the signup activity
        startActivity(intent);
    }
}


