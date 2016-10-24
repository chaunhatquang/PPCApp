package com.perfectproperties.app.ppc_app.Buy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.perfectproperties.app.ppc_app.Activity.BuyActivity;
import com.perfectproperties.app.ppc_app.Other.Model;
import com.perfectproperties.app.ppc_app.R;

import java.io.ByteArrayInputStream;

public class DetailBuyActivity extends AppCompatActivity {
    ImageView img,imgmap;
    ImageView imgcall,imgmail;
    TextView tvtitle;
    TextView tvdes;
    Toolbar toolbar;
    TextView title,tvPrice;
    ImageView imgback,imgdirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buy);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        title= (TextView) toolbar.findViewById(R.id.toolbar_title);
        title.setText("Chi Tiết Dự Án");
        imgback = (ImageView) toolbar.findViewById(R.id.imgback);
        imgdirect= (ImageView) toolbar.findViewById(R.id.imgdirect);
        imgdirect.setVisibility(View.GONE);

        img= (ImageView) findViewById(R.id.imgDetail);
        tvtitle= (TextView) findViewById(R.id.tvten);
        tvdes= (TextView) findViewById(R.id.txtmota);
        imgcall= (ImageView) findViewById(R.id.img_call);
        imgmail= (ImageView) findViewById(R.id.img_mail);
        imgmap= (ImageView) findViewById(R.id.img_location);

        Intent intent = getIntent();
        final Model model = (Model) intent.getSerializableExtra("data");
        byte[] blob = model.getThumb();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(blob);
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        img.setImageBitmap(bitmap);

        tvtitle.setText(model.getProject().toString());
        tvdes.setText("View:  "+model.getView()+"\n"+"Thành Phố:  "+model.getCity()+"\n"+"Quận:  "+model.getDistrict()+"\n"+"Giá:  "+model.getPrice()+"\n"+"Phòng Ngủ:  "+model.getBadRoom()+"\n"
        +"Thông tin luu ý:  "+model.getNote()
        );

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentback=new Intent(DetailBuyActivity.this,BuyActivity.class);
                startActivity(intentback);
            }
        });
        imgmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Project "+ model.getProject());
                intent.setData(Uri.parse("mailto:info@perfectproperties.vn"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        imgcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "0838221122";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });





        imgmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = model.getLat();
                Float lat= Float.parseFloat(s);
                String l=model.getLon();
                float lon=Float.parseFloat(l);
                Intent intent1=new Intent(DetailBuyActivity.this,MapsActivity.class);
                intent1.putExtra("lat",lat);
                intent1.putExtra("lon",lon);
                startActivity(intent1);
            }
        });

    }
}
