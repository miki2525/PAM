package com.pjatk.bmi.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.pjatk.bmi.R;
import com.pjatk.bmi.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class ChartFragment extends Fragment {

    private TextView recipeTextView;
    private Button showRecipeButton;

    private Spinner recipeSpinner;

    private List<Recipe> recipeList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);

        recipeList.add(new Recipe("Chicken Alfredo", getResources().getStringArray(R.array.recipe_ingredients_chicken_alfredo), getResources().getStringArray(R.array.recipe_instructions_chicken_alfredo)));
        recipeList.add(new Recipe("Beef Stroganoff", getResources().getStringArray(R.array.recipe_ingredients_beef_stroganoff), getResources().getStringArray(R.array.recipe_instructions_beef_stroganoff)));

        recipeTextView = view.findViewById(R.id.recipeTextView);
        showRecipeButton = view.findViewById(R.id.showRecipeButton);
        recipeSpinner = view.findViewById(R.id.recipeSpinner);

        showRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedRecipeIndex = recipeSpinner.getSelectedItemPosition();

                Recipe selectedRecipe = recipeList.get(selectedRecipeIndex);

                StringBuilder sb = new StringBuilder();
                sb.append("INGREDIENTS:").append("\n");
                for (String ingredient : selectedRecipe.getIngredients()) {
                    sb.append(ingredient).append("\n");
                }
                sb.append("INSTRUCTIONS:").append("\n");
                for (String instruction : selectedRecipe.getInstructions()) {
                    sb.append(instruction).append("\n");
                }

                recipeTextView.setText(sb.toString());
            }
        });
        return view;
    }

}
