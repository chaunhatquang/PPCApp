package com.perfectproperties.app.ppc_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.perfectproperties.app.ppc_app.Activity.DetailNewActivity;
import com.perfectproperties.app.ppc_app.Other.Item_News;
import com.perfectproperties.app.ppc_app.R;
import com.perfectproperties.app.ppc_app.SellDatabaseOpenHelper;

import java.util.List;

/**
 * Created by haitr on 10/17/2016.
 */

public class NewsAdapter extends RecyclerView.Adapter<RecyclerViewHolder_News> {
    private List<Item_News> item_news;
    private Context context;
    private SellDatabaseOpenHelper helper;

    public NewsAdapter(List<Item_News> item_news, Context context) {
        this.item_news = item_news;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder_News onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemfornews, null);
        RecyclerViewHolder_News viewHolder = new RecyclerViewHolder_News(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder_News holder, final int position) {
        holder.txtTitle.setText(item_news.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),DetailNewActivity.class);
                i.putExtra("Link",item_news.get(position).getLink());
                context.startActivity(i);
            }
        });

    }


    @Override
    public int getItemCount() {
        return item_news.size();
    }
}
