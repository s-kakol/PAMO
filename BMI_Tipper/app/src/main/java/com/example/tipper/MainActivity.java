package com.example.tipper;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bmiButton = findViewById(R.id.bmiButton);
        Button bmiHistoryButton = findViewById(R.id.bmiHistoryButton);
        Button calorieButton = findViewById(R.id.calorieButton);
        Button recipeButton = findViewById(R.id.recipeButton);
        Button quizButton = findViewById(R.id.quizButton);

        bmiButton.setOnClickListener(v -> openBmiActivity());
        bmiHistoryButton.setOnClickListener(v -> openBmiHistoryActivity());
        calorieButton.setOnClickListener(v -> openCaloriesActivity());
        recipeButton.setOnClickListener(v -> openRecipeActivity());
        quizButton.setOnClickListener(v -> openQuizActivity());
    }

    public void openBmiActivity() {
        Intent intent = new Intent(this, BmiActivity.class);
        startActivity(intent);
    }

    public void openCaloriesActivity() {
        Intent intent = new Intent(this, CaloriesActivity.class);
        startActivity(intent);
    }

    public void openRecipeActivity() {
        Intent intent = new Intent(this, RecipeActivity.class);
        startActivity(intent);
    }

    public void openBmiHistoryActivity() {
        Intent intent = new Intent(this, BmiHistoryActivity.class);
        startActivity(intent);
    }

    public void openQuizActivity() {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
} 