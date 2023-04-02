package com.example.yogabot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    EditText et_UserName, et_age, et_weight, et_height, et_phoneNumber,et_EmailAddress, et_password, et_confirmPassword;
    Button signUp_button;
    RadioGroup et_gender;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signUp_button = findViewById(R.id.signUp_button);
        et_UserName = findViewById(R.id.et_UserName);
        et_age = findViewById(R.id.et_age);
        et_weight = findViewById(R.id.et_weight);
        et_gender = findViewById(R.id.et_gender);
        et_height = findViewById(R.id.et_height);
        et_phoneNumber = findViewById(R.id.et_phoneNumber);
        et_EmailAddress = findViewById(R.id.et_EmailAddress);
        et_password = findViewById(R.id.et_password);
        DB = new DBHelper(this);
        et_confirmPassword = findViewById(R.id.et_confirmPassword);
        signUp_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_UserName.getText().toString();
                int userAge = Integer.parseInt(et_age.getText().toString());
                int userWeight = Integer.parseInt(et_weight.getText().toString());
                int userHeight = Integer.parseInt(et_height.getText().toString());
                String userPhoneNumber = et_phoneNumber.getText().toString();
                String password = et_password.getText().toString();
                String userEmail = et_EmailAddress.getText().toString();
                String confirmPassword = et_confirmPassword.getText().toString();
                if (TextUtils.isEmpty(et_UserName.getText().toString())){
                    et_UserName.setError("Enter Your Name");
                    return;
                }
                int selectedGenderId = et_gender.getCheckedRadioButtonId();
                if (selectedGenderId == -1) {
                    Toast.makeText(signup.this, "Please select your gender", Toast.LENGTH_SHORT).show();
                    return;
                } if (TextUtils.isEmpty(et_age.getText().toString())){
                    et_age.setError("Enter Your Age");
                    return;
                }
                if (TextUtils.isEmpty(et_height.getText().toString())){
                    et_height.setError("Enter Your Height");
                    return;
                }
                if (TextUtils.isEmpty(et_phoneNumber.getText().toString())){
                    et_phoneNumber.setError("Enter Your Phone Number");
                    return;
                }
                if (TextUtils.isEmpty(et_EmailAddress.getText().toString())){
                    et_EmailAddress.setError("Enter your email");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    et_password.setError("Enter Your Password");
                    return;
                }
                if (TextUtils.isEmpty(confirmPassword)){
                    et_confirmPassword.setError("Confirm Your Password");
                    return;
                }

                else{
                    if (password.equals(confirmPassword)){
                        Boolean checkuser = DB.checkuserEmailAddress(userEmail);
                        if (checkuser == false){
                            Boolean insert = DB.insertData(username, userAge, userWeight, userHeight, userPhoneNumber, userEmail, password);
                            if (insert == true){
                                Toast.makeText(signup.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(signup.this, MainActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(signup.this, "Registered failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(signup.this, "User already exist", Toast.LENGTH_SHORT).show();

                        }
                    }
                    else{
                        et_confirmPassword.setError("Passwords do not match");
                    }

                }


            }
        });
    }

    public void signup_signin(View view) {
        Intent intent = new Intent(signup.this, login.class);
        startActivity(intent);
    }
}