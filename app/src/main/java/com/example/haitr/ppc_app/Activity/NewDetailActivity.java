package com.example.haitr.ppc_app.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.haitr.ppc_app.Other.Item_News;
import com.example.haitr.ppc_app.R;

import java.util.List;

public class NewDetailActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        String s = getIntent().getStringExtra("link");
        Toast.makeText(this, s+"", Toast.LENGTH_SHORT).show();
       /* webView = (WebView)findViewById(R.id.wb_detailnews);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("");*/
    }
}
