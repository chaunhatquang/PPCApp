package com.perfectproperties.app.ppc_app.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.perfectproperties.app.ppc_app.R;
import com.perfectproperties.app.ppc_app.SellsEntity;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * Created by Me on 10/19/2016.
 */

public class SellsAdapter extends ArrayAdapter<SellsEntity> {
    public Context context;
    private List<SellsEntity> sellsList;
    private int resource;

    public SellsAdapter(Context context, int resource, List<SellsEntity> list) {
        super(context, resource, list);
        this.context = context;
        this.resource = resource;
        this.sellsList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.itemforsell,null);

        TextView name = (TextView)convertView.findViewById(R.id.txtName);
        ImageView img = (ImageView)convertView.findViewById(R.id.image_sell);
        TextView price = (TextView)convertView.findViewById(R.id.text_Price);
        TextView type = (TextView)convertView.findViewById(R.id.text_Type);


        SellsEntity getSellsEntity = sellsList.get(position);
        name.setText(getSellsEntity.getProject());
        price.setText(getSellsEntity.getPrice());
        type.setText(getSellsEntity.getBlock());
        ByteArrayInputStream inputStream = new ByteArrayInputStream(getSellsEntity.getThumb());
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        img.setImageBitmap(bitmap);
        return convertView;
    }
}
