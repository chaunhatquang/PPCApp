package com.perfectproperties.app.ppc_app.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.perfectproperties.app.ppc_app.Buy.MapsActivity;
import com.perfectproperties.app.ppc_app.R;
import com.perfectproperties.app.ppc_app.SellsEntity;

import java.io.ByteArrayInputStream;

import static com.perfectproperties.app.ppc_app.R.id.imgback;
import static com.perfectproperties.app.ppc_app.R.id.imgdirect;


public class DetailedProjectActivity extends AppCompatActivity {
    TextView txtName,txtView,txtCity,txtDistrict,txtPrice,txtBadroom,txtNote;
    ImageView img,imgcall,imgmail,imgmaps;
    Toolbar toolbar;
    TextView title;
    ImageView imgbackDetailSell;
    ImageView imgdirectDetailSell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_project);
        Bundle b = getIntent().getBundleExtra("bundle");
        final SellsEntity sellsEntity = (SellsEntity)b.getSerializable("sell");
        txtName = (TextView)findViewById(R.id.txtTitle);
        txtPrice = (TextView)findViewById(R.id.txtPrice);
        txtView = (TextView)findViewById(R.id.txtView);
        txtCity = (TextView)findViewById(R.id.txtCity);
        txtDistrict = (TextView)findViewById(R.id.txtDistrict);
        txtBadroom = (TextView)findViewById(R.id.txtRoom);
        txtNote = (TextView)findViewById(R.id.txtNote);
        imgcall = (ImageView)findViewById(R.id.img_call);
        imgmail = (ImageView)findViewById(R.id.img_mail);
        imgmaps = (ImageView) findViewById(R.id.img_location);
        img = (ImageView)findViewById(R.id.imgBanner);

        txtName.setText(sellsEntity.getProject());
        txtPrice.setText(sellsEntity.getPrice());
        txtView.setText(sellsEntity.getView());
        txtCity.setText(sellsEntity.getCity());
        txtDistrict.setText(sellsEntity.getDistrict());
        txtBadroom.setText(sellsEntity.getRoom());
        txtNote.setText(sellsEntity.getNote());
        ByteArrayInputStream inputStream = new ByteArrayInputStream(sellsEntity.getThumb());
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        img.setImageBitmap(bitmap);
        imgmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Project "+ sellsEntity.getProject());
                intent.setData(Uri.parse("mailto:info@perfectproperties.vn"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        imgcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "0839262998";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });
        imgmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float lat=sellsEntity.getLaititude();
                float lon=sellsEntity.getLongtitude();
                Intent intent1=new Intent(DetailedProjectActivity.this,MapsActivity.class);
                intent1.putExtra("lat",lat);
                intent1.putExtra("lon",lon);
                startActivity(intent1);
            }
        });
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        title.setText(sellsEntity.getProject());
        imgbackDetailSell = (ImageView) toolbar.findViewById(imgback);
        imgdirectDetailSell = (ImageView) toolbar.findViewById(imgdirect);
        imgdirectDetailSell.setVisibility(View.GONE);
        imgbackDetailSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intentDetailSell = new Intent(v.getContext(),SellActivity.class);
                startActivity(intentDetailSell);*/
                finish();
            }
        });
    }


//    private void initToolBar() {
//        toolbar = (Toolbar)findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        toolbar.setNavigationIcon(R.drawable.back);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent back = new Intent(getApplicationContext(),SellActivity.class);
//                startActivity(back);
//            }
//        });
//    }


    public void imgLocation_Click(View view) {
        Intent intent_location = new Intent(DetailedProjectActivity.this, LocationActivity.class);
        startActivity(intent_location);
    }

}
