package com.pjatk.bmi.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.pjatk.bmi.R;

public class BMICalculatorFragment extends Fragment {

    private EditText ageEdit;
    private EditText weightEdit;
    private EditText heightEdit;
    private TextView bmiResultTextView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bmi_calculator, container, false);

        ageEdit = view.findViewById(R.id.ageEditText);
        weightEdit = view.findViewById(R.id.weightEditText);
        heightEdit = view.findViewById(R.id.heightEditText);
        bmiResultTextView = view.findViewById(R.id.resultTextView);
        Button btnCalculate = view.findViewById(R.id.btn_calculate_bmi);

        btnCalculate.setOnClickListener(buttonCalculateListener);

        return view;
    }

    private void calculate() {
        float weight = Float.parseFloat(weightEdit.getText().toString());
        float height = Float.parseFloat(heightEdit.getText().toString()) / 100;
        int age = Integer.parseInt(ageEdit.getText().toString());
        float bmi = weight / (height * height);

        String score = assessBmiScore(age, bmi);

        String result = "Your BMI is: " + String.format("%.2f", bmi) + ", " + score;

        bmiResultTextView.setText(result);
    }

    private final View.OnClickListener buttonCalculateListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            calculate();
        }
    };

    private String assessBmiScore(int age, float bmi) {
        String score = "";
        if (age < 25) {
            if (bmi < 19) {
                score = getUnderweightStatus();
            } else if (bmi > 24) {
                score = getOverweightStatus();
            } else {
                score = getHealthyweightStatus();
            }
        } else if (age > 65) {
            if (bmi < 24) {
                score = getUnderweightStatus();
            } else if (bmi > 29) {
                score = getOverweightStatus();
            } else {
                score = getHealthyweightStatus();
            }
        } else {
            if (bmi < 20) {
                score = getUnderweightStatus();
            } else if (bmi > 28) {
                score = getOverweightStatus();
            } else {
                score = getHealthyweightStatus();
            }
        }
        return score;
    }

    private String getHealthyweightStatus() {
        return getResources().getString(R.string.bmi_score_healthy_weight);
    }

    private String getOverweightStatus() {
        return getResources().getString(R.string.bmi_score_overweight);
    }

    private String getUnderweightStatus() {
        return getResources().getString(R.string.bmi_score_underweight);
    }
}

