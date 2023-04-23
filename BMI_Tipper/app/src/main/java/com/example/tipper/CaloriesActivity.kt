package com.example.tipper

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CaloriesActivity : AppCompatActivity() {
    private var weight = 0.1
    private var height = 0.1
    private var age = 0
    private var gender = 0
    private var heightTextView: TextView? = null
    private var weightTextView: TextView? = null
    private var ageTextView: TextView? = null
    private var genderTextView: TextView? = null
    private var totalTextView: TextView? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calories)
        weightTextView = findViewById(R.id.weightTextView)
        heightTextView = findViewById(R.id.heightTextView)
        ageTextView = findViewById(R.id.ageTextView)
        genderTextView = findViewById(R.id.genderTextView)
        totalTextView = findViewById(R.id.totalTextView)

        totalTextView?.setText(0.toString() + "")

        val weightEditText = findViewById<EditText>(R.id.weightEditText)
        weightEditText.addTextChangedListener(weightEditTextWatcher)

        val heightEditText = findViewById<EditText>(R.id.heightEditText)
        heightEditText.addTextChangedListener(heightEditTextWatcher)

        val ageEditText = findViewById<EditText>(R.id.ageEditText)
        ageEditText.addTextChangedListener(ageEditTextWatcher)

        val genderEditText = findViewById<EditText>(R.id.genderEditText)
        genderEditText.addTextChangedListener(genderEditTextWatcher)
    }

    private fun calculate() {
        val result: Double = if (gender == 0) {
            //male calculation
            66.5 + 13.75 * weight + 5.003 * height - 6.775 * age
        } else {
            //female calculation
            665.1 + 9.563 * weight + 1.85 * height - 4.676 * age
        }
        totalTextView!!.text = String.format(
                result.toString() + "")
    }

    private val weightEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
            try {
                weight = s.toString().toDouble()
                weightTextView!!.text = String.format(weight.toString() + "")
            } catch (e: NumberFormatException) {
                weightTextView!!.text = ""
                weight = 0.0
            }
            calculate()
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {
        }
    }
    private val heightEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
            try {
                height = s.toString().toDouble()
                heightTextView!!.text = String.format(height.toString() + "")
            } catch (e: NumberFormatException) {
                heightTextView!!.text = ""
                height = 0.0
            }
            calculate()
        }

        override fun afterTextChanged(s: Editable) {}
    }
    private val ageEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
            try {
                age = s.toString().toInt()
                ageTextView!!.text = String.format(age.toString() + "")
            } catch (e: NumberFormatException) {
                age = 0
            }
            calculate()
        }

        override fun afterTextChanged(s: Editable) {}
    }
    private val genderEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
            try {
                gender = s.toString().toInt()
                genderTextView!!.text = String.format(getGender(gender) + "")
            } catch (e: NumberFormatException) {
                gender = 0
            }
            calculate()
        }

        override fun afterTextChanged(s: Editable) {}
    }

    fun getGender(gender: Int): String {
        return if (gender == 0) {
            "Male"
        } else {
            "Female"
        }
    }
}