package com.perfectproperties.app.ppc_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.perfectproperties.app.ppc_app.Activity.DetailedProjectActivity;
import com.perfectproperties.app.ppc_app.R;

/**
 * Created by haitr on 10/16/2016.
 */
public class RecyclerViewHolder_Sell extends RecyclerView.ViewHolder {
    public TextView txtPrice, txtType;
    public ImageView img_Sell;
    private static Context context;

    public RecyclerViewHolder_Sell(View itemView) {
        super(itemView);
        context = itemView.getContext();
        txtPrice = (TextView) itemView.findViewById(R.id.text_Price);
        txtType = (TextView) itemView.findViewById(R.id.text_Type);
        img_Sell = (ImageView) itemView.findViewById(R.id.image_sell);
        img_Sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent item = new Intent(context, DetailedProjectActivity.class);
                context.startActivity(item);
            }
        });
    }
}
