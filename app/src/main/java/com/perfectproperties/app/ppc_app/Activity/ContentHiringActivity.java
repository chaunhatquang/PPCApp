package com.perfectproperties.app.ppc_app.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.perfectproperties.app.ppc_app.R;

import static com.perfectproperties.app.ppc_app.R.id.imgback;
import static com.perfectproperties.app.ppc_app.R.id.imgdirect;


/**
 * Created by Me on 10/21/2016.
 */

public class ContentHiringActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView title;
    ImageView imgbackHiring;
    ImageView imgdirectHiring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_hiring);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        title.setText("Chi Tiết Tuyển Dụng");
        imgbackHiring = (ImageView) toolbar.findViewById(imgback);
        imgdirectHiring = (ImageView) toolbar.findViewById(imgdirect);
        imgdirectHiring.setVisibility(View.GONE);
        imgbackHiring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( getFragmentManager().getBackStackEntryCount() > 0)
                {
                    getFragmentManager().popBackStack();
                    return;
                }
                ContentHiringActivity.super.onBackPressed();
            }
        });
    }
}
