package com.example.tipper

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bmiButton = findViewById<Button>(R.id.bmiButton)
        val bmiHistoryButton = findViewById<Button>(R.id.bmiHistoryButton)
        val calorieButton = findViewById<Button>(R.id.calorieButton)
        val recipeButton = findViewById<Button>(R.id.recipeButton)
        val quizButton = findViewById<Button>(R.id.quizButton)

        bmiButton.setOnClickListener { openBmiActivity() }
        bmiHistoryButton.setOnClickListener { openBmiHistoryActivity() }
        calorieButton.setOnClickListener { openCaloriesActivity() }
        recipeButton.setOnClickListener { openRecipeActivity() }
        quizButton.setOnClickListener { openQuizActivity() }
    }

    private fun openBmiActivity() {
        val intent = Intent(this, BmiActivity::class.java)
        startActivity(intent)
    }

    private fun openCaloriesActivity() {
        val intent = Intent(this, CaloriesActivity::class.java)
        startActivity(intent)
    }

    private fun openRecipeActivity() {
        val intent = Intent(this, RecipeActivity::class.java)
        startActivity(intent)
    }

    private fun openBmiHistoryActivity() {
        val intent = Intent(this, BmiHistoryActivity::class.java)
        startActivity(intent)
    }

    private fun openQuizActivity() {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }
}