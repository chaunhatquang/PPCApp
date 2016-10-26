package com.perfectproperties.app.ppc_app.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.perfectproperties.app.ppc_app.Other.Model;
import com.perfectproperties.app.ppc_app.R;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * Created by Me on 10/18/2016.
 */

public class AdapterThue extends BaseAdapter {
    private List<Model> mStore;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public AdapterThue(Context context, List<Model> stores) {
        this.mContext = context;
        this.mStore = stores;
        this.mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return mStore != null ? mStore.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mStore.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_for_rent, null);
            holder = new ViewHolder();
            holder.linkHinh = (ImageView) convertView.findViewById(R.id.imgThumb);
            holder.tv= (TextView) convertView.findViewById(R.id.tvtitles);
            holder.txtPrice= (TextView) convertView.findViewById(R.id.txtgiaProject);
            holder.txtBlock= (TextView) convertView.findViewById(R.id.txtblock);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Model model = (Model) this.mStore.get(position);

        byte[] blob = model.getThumb();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(blob);
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

        holder.linkHinh.setImageBitmap(bitmap);
        holder.tv.setText(model.getProject().toString());
        String s=model.getPrice().toString();
        holder.txtPrice.setText(s);
        holder.txtBlock.setText(model.getBlock().toString());


        return convertView;
    }
    public class ViewHolder {
        private  ImageView linkHinh;
        TextView tv,txtPrice,txtBlock;


    }
}
