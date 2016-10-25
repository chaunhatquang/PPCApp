package com.perfectproperties.app.ppc_app.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.perfectproperties.app.ppc_app.R;

import static com.perfectproperties.app.ppc_app.R.id.imgback;
import static com.perfectproperties.app.ppc_app.R.id.imgdirect;

public class NewDetailActivity extends AppCompatActivity {
    private WebView webView;
    Toolbar toolbar;
    TextView title;
    ImageView imgbackNews;
    ImageView imgdirectNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_new);
        webView = (WebView) findViewById(R.id.wb_new);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String url = extras.getString("Link");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        title.setText(R.string.item_detail_new);
        imgbackNews = (ImageView) toolbar.findViewById(imgback);
        imgdirectNews = (ImageView) toolbar.findViewById(imgdirect);
        imgdirectNews.setVisibility(View.GONE);
        imgbackNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFragmentManager().getBackStackEntryCount() > 0) {
                    getFragmentManager().popBackStack();
                    return;
                }
                NewDetailActivity.super.onBackPressed();
            }
        });
    }

}
