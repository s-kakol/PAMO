package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;

public class RecipeActivity extends AppCompatActivity {
    private TextView recipeCacio;
    private TextView recipeKedgeree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        recipeCacio = (TextView) findViewById(R.id.recipe_1);
        recipeKedgeree = (TextView) findViewById(R.id.recipe_2);
    }
}