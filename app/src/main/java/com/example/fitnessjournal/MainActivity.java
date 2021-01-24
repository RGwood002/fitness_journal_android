package com.example.fitnessjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //checking if user input is pounds or kilo
    ToggleButton unitButton;
    Button convertButton;
    EditText weightField;
    TextView conversionNum;
    Button home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         unitButton = (ToggleButton) findViewById(R.id.kiloOrPound);
         convertButton = (Button) findViewById(R.id.convertButton);

         weightField = (EditText) findViewById(R.id.weightInput);
         conversionNum = (TextView) findViewById(R.id.conversionOutput);
         home = (Button) findViewById(R.id.home_button);


        unitButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    unitButton.setChecked(true);
                } else{
                    unitButton.setChecked(false);
                }
            }
        });

        convertButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                boolean unitButtonState = unitButton.isChecked();
                String weightText = weightField.getText().toString();

                double preConversionWeight = Integer.parseInt(weightText);
                double finalWeight = 0;
                DecimalFormat f = new DecimalFormat("##.00");

                if(!unitButtonState){
                    finalWeight = preConversionWeight * .45359237;
                    conversionNum.setText(getString(R.string.convert_to_kilo, f.format(finalWeight)));
                } else{
                    finalWeight = preConversionWeight / .45359237;
                    conversionNum.setText(getString(R.string.convert_to_pounds,  f.format(finalWeight)));
                }
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Home.class);
                startActivity(intent);
            }
        });


    }
}