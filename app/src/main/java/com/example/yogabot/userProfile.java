package com.example.yogabot;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link userProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class userProfile extends Fragment {
    TextView username_input_name,username_input_email, username_input_phoneNumber, username_input_height, username_input_age;
    String email;
    UserDetail arrUser;



    public userProfile() {
        // Required empty public constructor
    }

    public static userProfile newInstance(String param1, String param2) {
        userProfile fragment = new userProfile();
        Bundle args = new Bundle();
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        Button profile_login_button = view.findViewById(R.id.profile_login_button);
        Button profile_edit_button = view.findViewById(R.id.profile_edit_button);
        TextView username_input_name = view.findViewById(R.id.username_input_name);
        TextView username_input_email  = view.findViewById(R.id.username_input_email);
        TextView username_input_age  = view.findViewById(R.id.username_input_age);
        TextView username_input_phoneNumber  = view.findViewById(R.id.username_input_phoneNumber);
        TextView username_input_height  = view.findViewById(R.id.username_input_height);
        TextView username_input_weight  = view.findViewById(R.id.username_input_weight);
        profile_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), login.class);
                startActivity(intent);
            }
        });
        profile_edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), updateProfile.class);
                startActivity(intent);
            }
        });

       DBHelper dbHelper = new DBHelper(getContext());
       ArrayList<UserDetail> arrUser = dbHelper.fetchData();
        for (int i = 0; i < arrUser.size(); i++) {
            UserDetail user = arrUser.get(i);
            username_input_name.setText(user.getName());
            username_input_email.setText(user.getEmail());
            username_input_phoneNumber.setText(user.getPhoneNumber());
            String ageStr = String.valueOf(user.getAge());
            username_input_age.setText(ageStr);
            String heightStr = String.valueOf(user.getHeight());
            username_input_height.setText(heightStr);
            String weightStr = String.valueOf(user.getWeight());
            username_input_weight.setText(weightStr);

            // Set the values for other TextViews as needed
        }



        return view;
    }

}