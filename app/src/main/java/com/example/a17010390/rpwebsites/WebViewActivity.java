package com.example.a17010390.rpwebsites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    WebView wvMypage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wvMypage = findViewById(R.id.wvPage);

        wvMypage.setWebViewClient(new WebViewClient());
        wvMypage.getSettings().setJavaScriptEnabled(true);
        wvMypage.getSettings().setAllowFileAccess(false);
        wvMypage.getSettings().setBuiltInZoomControls(true);

        Intent intentReceive = getIntent();
        String url = intentReceive.getStringExtra("url");

        }
    }