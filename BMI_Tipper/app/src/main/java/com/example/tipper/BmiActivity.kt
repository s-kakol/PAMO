package com.example.tipper

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt

class BmiActivity : AppCompatActivity() {
    private var cmHeight = 0
    private var kgWeight = 0.0
    private var heightTextView
            : TextView? = null
    private var weightTextView
            : TextView? = null
    private var totalTextView
            : TextView? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        heightTextView = findViewById(R.id.heightTextView)
        weightTextView = findViewById(R.id.weightTextView)
        totalTextView = findViewById(R.id.totalTextView)
        totalTextView?.setText(0.toString() + "")

        val heightEditText = findViewById<EditText>(R.id.heightEditText)
        heightEditText.addTextChangedListener(heightEditTextWatcher)
        val weightEditText = findViewById<EditText>(R.id.weightEditText)
        weightEditText.addTextChangedListener(weightEditTextWatcher)
    }

    @SuppressLint("SetTextI18n")
    private fun calculate() {
        val bmi = kgWeight / cmHeight / cmHeight * 10000
        totalTextView!!.text = ((bmi * 100.0).roundToInt() / 100.0).toString() + ""
    }

    private val heightEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
            try {
                cmHeight = s.toString().toInt()
                heightTextView!!.text = String.format(cmHeight.toString() + "")
            } catch (e: NumberFormatException) {
                heightTextView!!.text = ""
                cmHeight = before
            }
            calculate()
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {
        }
    }
    private val weightEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
            try {
                kgWeight = s.toString().toDouble()
                weightTextView!!.text = String.format(kgWeight.toString() + "")
            } catch (e: NumberFormatException) {
                weightTextView!!.text = ""
                kgWeight = before * 1.0
            }
            calculate()
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {
        }
    }
}