package com.perfectproperties.app.ppc_app.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.perfectproperties.app.ppc_app.R;

/**
 * Created by haitr on 10/18/2016.
 */

public class RecyclerViewHolder_Hiring extends RecyclerView.ViewHolder {
    public TextView txtTitle;
    public ImageView img_Hiring;

    public RecyclerViewHolder_Hiring(View itemView) {
        super(itemView);
        txtTitle = (TextView) itemView.findViewById(R.id.text_hiring);
        img_Hiring = (ImageView) itemView.findViewById(R.id.image_hiring);
    }
}
