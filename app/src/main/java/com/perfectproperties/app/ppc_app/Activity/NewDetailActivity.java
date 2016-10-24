package com.perfectproperties.app.ppc_app.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.perfectproperties.app.ppc_app.R;

public class NewDetailActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        webView = (WebView)findViewById(R.id.wb_news);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String url = extras.getString("Link");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }
}
