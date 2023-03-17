package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.widget.EditText;
import android.widget.TextView; // for displaying text

import java.text.NumberFormat; // for currency formatting

public class MainActivity extends AppCompatActivity {
    private int cmHeight = 0; // height entered by the user
    private double kgWeight = 0.0; // weight entered by the user
    private TextView heightTextView; // shows the height
    private TextView weightTextView; // shows the weight
    private TextView totalTextView; // shows calculated bmi

    // called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call superclass onCreate
        setContentView(R.layout.activity_main); // inflate the GUI

        // get references to programmatically manipulated TextViews
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        weightTextView = (TextView) findViewById(R.id.weightTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        totalTextView.setText(String.format(0 + ""));

        // set watchers
        EditText heightEditText =
                (EditText) findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(heightEditTextWatcher);

        EditText weightEditText =
                (EditText) findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(weightEditTextWatcher);
    }

    // calculate and display tip and total amounts
    private void calculate() {
        double bmi = (kgWeight / cmHeight / cmHeight) * 10000;
        totalTextView.setText(String.format((Math.round(bmi * 100.0) / 100.0) + ""));
    }

    // listener object for the EditText's text-changed events
    private final TextWatcher heightEditTextWatcher = new TextWatcher() {
        // called when the user modifies the height
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                cmHeight = Integer.parseInt(s.toString());
                heightTextView.setText(String.format(cmHeight + ""));
            } catch (NumberFormatException e) { // if s is empty or non-numeric
                heightTextView.setText("");
                cmHeight = before;
            }

            calculate(); // update bmi value
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };

    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
        // called when the user modifies the weight
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                kgWeight = Double.parseDouble(s.toString());
                weightTextView.setText(String.format(kgWeight + ""));
            } catch (NumberFormatException e) { // if s is empty or non-numeric
                weightTextView.setText("");
                kgWeight = before * 1.0;
            }

            calculate(); // update bmi value
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };
}


/*************************************************************************
 * (C) Copyright 1992-2016 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
