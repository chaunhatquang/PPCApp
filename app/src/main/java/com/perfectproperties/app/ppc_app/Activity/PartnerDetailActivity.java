package com.perfectproperties.app.ppc_app.Activity;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.perfectproperties.app.ppc_app.R;

import static com.perfectproperties.app.ppc_app.R.id.imgback;
import static com.perfectproperties.app.ppc_app.R.id.imgdirect;


public class PartnerDetailActivity extends AppCompatActivity {
    WebView webView;
    Toolbar toolbar;
    TextView title;
    ImageView imgbackPartner;
    ImageView imgdirectPartner;

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_detail);
        final ProgressDialog pd = ProgressDialog.show(this, "", "Loading....", true);
        webView = (WebView) findViewById(R.id.wb_partner);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        String url = getIntent().getStringExtra("Link");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pd.dismiss();
            }
        });
        webView.loadUrl(url);
        // Set Function Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        title.setText("Chi Tiết Đối Tác");
        imgbackPartner = (ImageView) toolbar.findViewById(imgback);
        imgdirectPartner = (ImageView) toolbar.findViewById(imgdirect);
        imgdirectPartner.setVisibility(View.GONE);
        imgbackPartner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( getFragmentManager().getBackStackEntryCount() > 0)
                {
                    getFragmentManager().popBackStack();
                    return;
                }
                PartnerDetailActivity.super.onBackPressed();
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("DetailNew Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}

