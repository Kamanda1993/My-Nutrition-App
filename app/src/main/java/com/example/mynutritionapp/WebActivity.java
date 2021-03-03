package com.example.mynutritionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        mWebView = findViewById(R.id.webview);

        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebView.loadUrl("https://www.google.com/search?q=Nutrition+health+tips&tbm=isch&ved=2ahUKEwj934XtnofvAhUzgXMKHVvoDVIQ2-cCegQIABAA&oq=Nutrition+health+tips&gs_lcp=CgNpbWcQAzICCAAyAggAMgIIADICCAAyBggAEAUQHjIGCAAQCBAeMgYIABAIEB46BwgjEOoCECc6BAgjECc6BAgAEEM6BQgAELEDOgcIABCxAxBDOgoIABCxAxCDARBDUKf51ANYnurVA2Clk9YDaAJwAHgEgAG-BIgBqV-SAQY0LTIwLjaYAQCgAQGqAQtnd3Mtd2l6LWltZ7ABB8ABAQ&sclient=img&ei=3b84YL39HbOCzgPb0LeQBQ&bih=625&biw=1366&safe=active#imgrc=456z84k6UxiLTM");

    }
}