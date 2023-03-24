package com.pjatk.bmi.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.pjatk.bmi.MainActivity;
import com.pjatk.bmi.R;

public class CaloriesFragment extends Fragment {

    private EditText ageEdit;
    private EditText weightEdit;
    private EditText heightEdit;
    private TextView caloriesResultTextView;

    private Spinner genderDropdownList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calories, container, false);

        ageEdit = view.findViewById(R.id.ageEditText);
        weightEdit = view.findViewById(R.id.weightEditText);
        heightEdit = view.findViewById(R.id.heightEditText);
        caloriesResultTextView = view.findViewById(R.id.caloriesResultTextView);

        genderDropdownList = view.findViewById(R.id.genderDropdownList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item);
        String[] items = getResources().getStringArray(R.array.gender_dropdown);
        adapter.addAll(items);
        genderDropdownList.setAdapter(adapter);

        Button btnCalculate = view.findViewById(R.id.btn_calculate_bmi);


        btnCalculate.setOnClickListener(buttonCalculateListener);

        return view;
    }

    private void calculate() {
        Gender gender = Gender.valueOf(genderDropdownList.getSelectedItem().toString());
        float weight = Float.parseFloat(weightEdit.getText().toString());
        float height = Float.parseFloat(heightEdit.getText().toString());
        int age = Integer.parseInt(ageEdit.getText().toString());

        String result = "";
        if (gender == Gender.MALE) {
            result = String.format("%.2f", 66.47 + (13.7 * weight) + (5.0 * height) - (6.76 * age));
        } else {
            result = String.format("%.2f", 655.1 + (9.567 * weight) + (1.85 * height) - (4.68 * age));
        }

        caloriesResultTextView.setText(result);
    }

    private final View.OnClickListener buttonCalculateListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            calculate();
        }
    };

    public enum Gender {
        MALE,
        FEMALE
    }
}

