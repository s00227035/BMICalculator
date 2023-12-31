package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VARIABLES etc.
        EditText editTextWeight = findViewById(R.id.personWeight);
        EditText editTextHeight = findViewById(R.id.personHeight);
        Button btnCalculate = findViewById(R.id.buttonCalculate);
        Button btnReset = findViewById(R.id.buttonReset);



        //CALCULATION, RESET TEXT AFTER CLICK AND 2nd ACTIVITY
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double height = Double.parseDouble(String.valueOf(editTextHeight.getText())) / 100;
                double weight = Double.parseDouble(String.valueOf(editTextWeight.getText()));
                double bmiResult = weight / (height * height);

                editTextWeight.setText("");
                editTextHeight.setText("");
                //if (height <= 80 && weight <= 20 || height >= 300 && weight >= 200) {}

                    Intent Activity2 = new Intent(getApplicationContext(), Activity2.class);
                    Activity2.putExtra("key", bmiResult);
                    startActivity(Activity2);}
            });

        //RESET BUTTON
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextHeight.setText("");
                editTextWeight.setText("");
            }
        });
    }
}



