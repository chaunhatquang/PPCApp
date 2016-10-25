package com.perfectproperties.app.ppc_app.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.perfectproperties.app.ppc_app.R;


/**
 * Created by haitr on 10/17/2016.
 */

public class RecyclerViewHolder_Partner extends RecyclerView.ViewHolder {
    public TextView txtName_Partner;
    public ImageView img_Partner;

    public RecyclerViewHolder_Partner(View itemView) {
        super(itemView);
        txtName_Partner = (TextView) itemView.findViewById(R.id.textName_Partner);
        img_Partner = (ImageView) itemView.findViewById(R.id.image_Partner);
    }
}
