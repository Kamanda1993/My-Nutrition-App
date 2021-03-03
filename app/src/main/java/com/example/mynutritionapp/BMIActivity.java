package com.example.mynutritionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import com.google.android.material.tabs.TabLayout;

import java.text.DecimalFormat;

public class BMIActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);

        EditText edWeg,edHei;
        TextView txtRes, txtInter;
        Button btnRes,btnReset;

        edWeg=(EditText) findViewById(R.id.edweg);
        edHei=(EditText) findViewById(R.id.edhei);

        txtInter = findViewById(R.id.txtinter);
        txtRes=(TextView) findViewById(R.id.txtres);

        btnRes=(Button) findViewById(R.id.btnres);
        btnReset=(Button) findViewById(R.id.btnreset);

        //setting on click listeners on buttons
        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight, height;

                //get weight and height from users
                weight=edWeg.getText().toString().trim();
                height = edHei.getText().toString().trim();

                if (weight.isEmpty()){
                    edWeg.setError("Please enter your weight");
                } else if (height.isEmpty()){
                    edHei.setError("Please enter your height");
                } else {
                    Double BMI;
                    BMI = Double.parseDouble(weight)/((Double.parseDouble(height)*Double.parseDouble(height)/100));

                  if (BMI < 15) {
                        txtInter.setText("Severly Under Weight");
                    } else if (BMI <18.5){
                        txtInter.setText("Under Weight");
                    }else if (BMI< 20){
                        txtInter.setText("Normal Weight");
                    } else if (BMI<25){
                        txtInter.setText("Over Weight");
                    } else {
                        txtInter.setText("Obese");
                    }
                    txtRes.setText(String.valueOf(BMI));
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edHei.setText("");
                edWeg.setText("");
                txtInter.setText("");
                txtRes.setText("");
            }
        });


    }
}