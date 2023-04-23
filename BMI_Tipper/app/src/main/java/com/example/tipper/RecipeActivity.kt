package com.example.tipper

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        val recipeCacio = findViewById<TextView>(R.id.recipe_1)
        val recipeKedgeree = findViewById<TextView>(R.id.recipe_2)
    }
}