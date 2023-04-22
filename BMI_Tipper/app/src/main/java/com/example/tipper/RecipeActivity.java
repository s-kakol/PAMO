package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        TextView recipeCacio = findViewById(R.id.recipe_1);
        TextView recipeKedgeree = findViewById(R.id.recipe_2);
    }
}