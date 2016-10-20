package com.example.haitr.ppc_app.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.haitr.ppc_app.R;

/**
 * Created by haitr on 10/17/2016.
 */

public class RecyclerViewHolder_News extends RecyclerView.ViewHolder{
    public TextView txtTitle;
//    int focus = 0;
//    SellDatabaseOpenHelper mSelldb;
//    List<Item_News> mLstItemNews;

    public RecyclerViewHolder_News(View itemView) {
        super(itemView);
        txtTitle = (TextView) itemView.findViewById(R.id.text_Title);
    }
}
