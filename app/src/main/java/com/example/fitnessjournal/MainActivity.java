package com.example.fitnessjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //checking if user input is pounds or kilo
        ToggleButton unitButton = (ToggleButton) findViewById(R.id.kiloOrPound);
        Boolean unitButtonState = unitButton.isChecked();

        EditText weightField = (EditText) findViewById(R.id.weightInput);
        TextView conversionNum = (TextView) findViewById(R.id.conversionOutput);

        String weightText = weightField.getText().toString();

        weightField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                
            }
        });
    }
}