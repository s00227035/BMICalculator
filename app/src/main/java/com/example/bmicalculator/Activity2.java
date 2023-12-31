package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView getResult;
    Button btnExit;
    Button buttonHealthy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        getResult = findViewById(R.id.textResult);
        Intent intent = getIntent();
        double dataPassed = intent.getDoubleExtra("key", 0);
        getResult.setText(Double.toString(dataPassed));

        //CLOSE THE SECOND ACTIVITY AND RETURN BACK
        btnExit = findViewById(R.id.buttonExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //CHANGE THE TEXT COLOR BASED ON THE RESULT
        buttonHealthy = findViewById( R.id.buttonHealthy );
        buttonHealthy.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(dataPassed < 18.5)
                {
                    buttonHealthy.setText("You are Underweight");
                    buttonHealthy.setTextColor( Color.RED);
                }
                else if(dataPassed >= 18.5 && dataPassed <= 24.9)
                {
                    buttonHealthy.setText("You are Healthy");
                    buttonHealthy.setTextColor( Color.GREEN);
                }
                else if(dataPassed >= 25 && dataPassed <= 29.9)
                {
                    buttonHealthy.setText("You are Overweight");
                    buttonHealthy.setTextColor(Color.YELLOW);
                }
                else if(dataPassed > 30)
                {
                    buttonHealthy.setText("You are Obese");
                    buttonHealthy.setTextColor(Color.RED);
                }
            }
        });
    }
}
