package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.view.View;
import android.widget.Button;
import android.widget.EditText; // for bill amount input
import android.widget.SeekBar; // for changing the tip percentage
import android.widget.SeekBar.OnSeekBarChangeListener; // SeekBar listener
import android.widget.TextView; // for displaying text

import java.text.NumberFormat; // for currency formatting

public class MainActivity extends AppCompatActivity {

    private EditText ageEdit;
    private EditText weightEdit;
    private EditText heightEdit;
    private TextView bmiResultTextView;

    private final String UNDERWEIGHT = "UNDERWEIGHT";
    private final String HEALTHY_WEIGHT = "HEALTHY_WEIGHT";
    private final String OVERWEIGHT = "OVERWEIGHT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get references to programmatically manipulated TextViews
        ageEdit = findViewById(R.id.ageEditText);
        weightEdit = findViewById(R.id.weightEditText);
        heightEdit = findViewById(R.id.heightEditText);
        bmiResultTextView = findViewById(R.id.resultTextView);
        Button btnCalculate = findViewById(R.id.btn_calculate_bmi);

        btnCalculate.setOnClickListener(buttonCalculateListener);

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
                score = UNDERWEIGHT;
            } else if (bmi > 24) {
                score = OVERWEIGHT;
            } else {
                score = HEALTHY_WEIGHT;
            }
        } else if (age > 65) {
            if (bmi < 24) {
                score = UNDERWEIGHT;
            } else if (bmi > 29) {
                score = OVERWEIGHT;
            } else {
                score = HEALTHY_WEIGHT;
            }
        } else {
            if (bmi < 20) {
                score = UNDERWEIGHT;
            } else if (bmi > 28) {
                score = OVERWEIGHT;
            } else {
                score = HEALTHY_WEIGHT;
            }
        }
        return score;
    }
}

