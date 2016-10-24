package com.perfectproperties.app.ppc_app.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.perfectproperties.app.ppc_app.R;

/**
 * Created by haitr on 10/17/2016.
 */

public class RecyclerViewHolder_News extends RecyclerView.ViewHolder {
    public TextView txtTitle, txtDetailed;
    public ImageView img_News;

    public RecyclerViewHolder_News(View itemView) {
        super(itemView);
        txtTitle = (TextView) itemView.findViewById(R.id.text_Title);
       // txtDetailed = (TextView) itemView.findViewById(R.id.text_detailNews);
        img_News = (ImageView) itemView.findViewById(R.id.img_News);
    }
}
