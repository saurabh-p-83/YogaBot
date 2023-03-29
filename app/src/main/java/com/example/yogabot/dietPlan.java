package com.example.yogabot;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class dietPlan extends Fragment {
    public CardView weightloss_dietplan, weightgain_dietplan, vegeterian_dietplan, hearthealth_dietplan, diabetes_dietplan, pregnantwomenyoga_dietplan, children_dietplan;

    public dietPlan() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diet_plan, container, false);
        weightloss_dietplan = view.findViewById(R.id.weightloss_dietplan);
        weightloss_dietplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), weightloss_dp.class);
                startActivity(intent);
            }
        });

        weightgain_dietplan = view.findViewById(R.id.weightgain_dietplan);
        weightgain_dietplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), weightgain_dp.class);
                startActivity(intent);
            }
        });
        vegeterian_dietplan = view.findViewById(R.id.vegeterian_dietplan);
        vegeterian_dietplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), vegetarian_dp.class);
                startActivity(intent);
            }
        });
        hearthealth_dietplan = view.findViewById(R.id.hearthealth_dietplan);
        hearthealth_dietplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), hearthealth_dp.class);
                startActivity(intent);
            }
        });
        diabetes_dietplan = view.findViewById(R.id.diabetes_dietplan);
        diabetes_dietplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), diabetes_dp.class);
                startActivity(intent);
            }
        });
        pregnantwomenyoga_dietplan = view.findViewById(R.id.pregnantwomenyoga_dietplan);
        pregnantwomenyoga_dietplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), pregnantwomen_dp.class);
                startActivity(intent);
            }
        });
        children_dietplan = view.findViewById(R.id.children_dietplan);
        children_dietplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), children_dp.class);
                startActivity(intent);
            }
        });


        return view;
    }
}