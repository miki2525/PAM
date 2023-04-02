package com.pjatk.bmi;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pjatk.bmi.ui.fragment.BMICalculatorFragment;
import com.pjatk.bmi.ui.fragment.CaloriesFragment;
import com.pjatk.bmi.ui.fragment.RecipeFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_bmi_calc);

    }

    BMICalculatorFragment bmiCalculatorFragment = new BMICalculatorFragment();

    CaloriesFragment caloriesFragment = new CaloriesFragment();

    RecipeFragment recipeFragment = new RecipeFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navigation_bmi_calc:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, bmiCalculatorFragment).commit();
                return true;

            case R.id.navigation_calories:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, caloriesFragment).commit();
                return true;

            case R.id.navigation_recipe:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, recipeFragment).commit();
                return true;
        }
        return false;
    }
}
