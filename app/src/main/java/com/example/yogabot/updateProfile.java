package com.example.yogabot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class updateProfile extends AppCompatActivity {
    EditText id_weight,id_phonenumber,id_name,id_height,id_age, id_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        // Initialize EditText variables with their respective IDs
        id_weight = findViewById(R.id.id_weight);
        id_phonenumber = findViewById(R.id.id_phoneNumber);
        id_height = findViewById(R.id.id_height);
        id_name = findViewById(R.id.id_name);
        id_age = findViewById(R.id.id_age);
        id_email = findViewById(R.id.id_email);
        // Create an instance of DBHelper class to fetch data from the database
        DBHelper dbHelper = new DBHelper(this);
        ArrayList<UserDetail> arrUser = dbHelper.fetchData();
        // Iterate through each UserDetail object and set their data to respective EditText fields
        for (int i = 0; i < arrUser.size(); i++) {
            UserDetail user = arrUser.get(i);
            id_name.setText(user.getName());
            String weightStr = String.valueOf(user.getWeight());
            id_weight.setText(weightStr);
            id_phonenumber.setText(user.getPhoneNumber());
            String ageStr = String.valueOf(user.getAge());
            String heightStr = String.valueOf(user.getHeight());
            id_height.setText(heightStr);
            id_age.setText(ageStr);

        }
    }
    // Function to update user's profile with the new data entered in the EditText fields
    public void updateMyProfile(View view){
        // Fetch the data entered in the EditText fields and convert them to respective data types
        String name = id_name.getText().toString();
        String  phonenumber = id_phonenumber.getText().toString();
        String email = id_email.getText().toString();
        int weight = Integer.parseInt(id_weight.getText().toString());
        int age = Integer.parseInt(id_age.getText().toString());
        int height = Integer.parseInt(id_height.getText().toString());
        // Create an instance of DBHelper class to update the user's data in the database
        DBHelper dbHelper = new DBHelper(this);
        boolean b = dbHelper.updateProfileHelper(name, age, height, weight, phonenumber, email);
        // Show a success/error message based on whether the data was updated successfully or not
        if(b){
            Toast.makeText(this, "Values Updated Successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(updateProfile.this, MainActivity.class);
            startActivity(intent);

        }
        else{
            Toast.makeText(this, "Error occurred", Toast.LENGTH_SHORT).show();
        }

    }
}


