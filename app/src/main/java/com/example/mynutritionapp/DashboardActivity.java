package com.example.mynutritionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class DashboardActivity extends AppCompatActivity {
    private WebView webView;
    ImageView img;
    ImageView img1;
    ImageView img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        img2 = findViewById(R.id.imageView5);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,NotebookActivity.class);
                startActivity(intent);
            }
        });

        img1 = findViewById(R.id.imageView7);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,MealplanActivity.class);
                startActivity(intent);
            }
        });

        img = findViewById(R.id.imageView6);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(DashboardActivity.this,WebActivity.class);
                    startActivity(intent);
            }
        });

    }

    public void next_view1(View view) {
        Intent intent = new Intent(DashboardActivity.this, NutriPlanActivity.class);
        startActivity(intent);
    }

    public void next_view2(View view) {
        Intent intent = new Intent(DashboardActivity.this, BMIActivity.class);
        startActivity(intent);

    }
    public void next_view3(View view) {
        Intent intent = new Intent(DashboardActivity.this, DiaryPlanActivity.class);
        startActivity(intent);
    }
    public void next_view4(View view) {
        Intent intent = new Intent(DashboardActivity.this, HealthTipsActivity.class);
        startActivity(intent);
    }

}