package com.example.tipper;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CaloriesActivity extends AppCompatActivity {

    private double weight = 0.1;
    private double height = 0.1;
    private int age = 0;
    private int gender = 0;

    private TextView heightTextView;
    private TextView weightTextView;
    private TextView ageTextView;
    private TextView genderTextView;
    private TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        weightTextView = (TextView) findViewById(R.id.weightTextView);
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        ageTextView = (TextView) findViewById(R.id.ageTextView);
        genderTextView = (TextView) findViewById(R.id.genderTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        totalTextView.setText(String.format(0 + ""));

        EditText weightEditText =
                (EditText) findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(weightEditTextWatcher);

        EditText heightEditText =
                (EditText) findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(heightEditTextWatcher);

        EditText ageEditText =
                (EditText) findViewById(R.id.ageEditText);
        ageEditText.addTextChangedListener(ageEditTextWatcher);

        EditText genderEditText =
                (EditText) findViewById(R.id.genderEditText);
        genderEditText.addTextChangedListener(genderEditTextWatcher);
    }

    private void calculate() {
        double result = 0.00;

        if (gender == 0) {
            //male calculation
            result = 66.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age);
        } else {
            //female calculation
            result = 665.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age);
        }

        totalTextView.setText(String.format(
                result + ""));
    }

    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                weight = Double.parseDouble(s.toString());
                weightTextView.setText(String.format(weight + ""));

            } catch (NumberFormatException e) {
                weightTextView.setText("");
                weight = 0.0;

            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };
    private final TextWatcher heightEditTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                height = Double.parseDouble(s.toString());
                heightTextView.setText(String.format(height + ""));
            } catch (NumberFormatException e) {
                heightTextView.setText("");
                height = 0.0;
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private final TextWatcher ageEditTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                age = (int) (Integer.parseInt(s.toString()));
                ageTextView.setText(String.format(age + ""));
            } catch (NumberFormatException e) {
                age = 0;
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private final TextWatcher genderEditTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                gender = (int) (Integer.parseInt(s.toString()));
                genderTextView.setText(String.format(getGender(gender) + ""));
            } catch (NumberFormatException e) {
                gender = 0;
            }

            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public String getGender(int gender) {
        if (gender == 0) {
            return "Male";
        } else {
            return "Female";
        }
    }
}