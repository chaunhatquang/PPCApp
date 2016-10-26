package com.perfectproperties.app.ppc_app.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.perfectproperties.app.ppc_app.Other.Item_Sell;
import com.perfectproperties.app.ppc_app.R;

import java.util.List;

/**
 * Created by haitr on 10/16/2016.
 */

public class SellAdapter extends RecyclerView.Adapter<RecyclerViewHolder_Sell> {
    private List<Item_Sell> item_sells;
    private Context context;

    public SellAdapter(List<Item_Sell> item_sells, Context context) {
        this.item_sells = item_sells;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder_Sell onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_sell, null);
        RecyclerViewHolder_Sell viewHolder = new RecyclerViewHolder_Sell(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder_Sell holder, int position) {
        holder.img_Sell.setImageResource(item_sells.get(position).getsThumbnail());
        holder.txtType.setText(item_sells.get(position).getsType());
        holder.txtPrice.setText(item_sells.get(position).getsPrice());

    }

    @Override
    public int getItemCount() {
        return this.item_sells.size();
    }
}
