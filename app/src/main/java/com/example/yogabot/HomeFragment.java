package com.example.yogabot;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;


public class

HomeFragment extends Fragment {
    private CardView fitness_cardView, weightloss_cardView, mentalhealth_cardView, hearthealth_cardView, sleepimprovement_cardView, childrenyoga_cardView, pregnantwomenyoga_cardView;



    public HomeFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the   layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        fitness_cardView =  view.findViewById(R.id.fitness_cardView);
        fitness_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), fitnessyoga.class);
                startActivity(intent);
            }

        });
        weightloss_cardView =  view.findViewById(R.id.weightloss_cardView);
        weightloss_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), fitnessyoga.class);
                startActivity(intent);
            }

        });
        mentalhealth_cardView =  view.findViewById(R.id.mentalhealth_cardView);
        mentalhealth_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), mentalhealthyoga.class);
                startActivity(intent);
            }

        });
        hearthealth_cardView =  view.findViewById(R.id.hearthealth_cardView);
        hearthealth_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), hearthealthyoga.class);
                startActivity(intent);
            }

        });
        sleepimprovement_cardView =  view.findViewById(R.id.sleepimprovement_cardView);
        sleepimprovement_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), sleepingimpromentyoga.class);
                startActivity(intent);
            }

        });
        childrenyoga_cardView =  view.findViewById(R.id.childrenyoga_cardView);
        childrenyoga_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), childrenyoga.class);
                startActivity(intent);
            }

        });
        pregnantwomenyoga_cardView =  view.findViewById(R.id.pregnantwomenyoga_cardView);
        pregnantwomenyoga_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), pregnantwomenyoga.class);
                startActivity(intent);
            }

        });


        return view;
    }

}