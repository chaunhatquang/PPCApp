package com.example.haitr.ppc_app.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haitr.ppc_app.Other.Item_Partner;
import com.example.haitr.ppc_app.R;

import java.util.List;

/**
 * Created by haitr on 10/17/2016.
 */

public class PartnerAdapter extends RecyclerView.Adapter<RecyclerViewHolder_Partner> {
    private List<Item_Partner> item_partners;
    private Context context;

    public PartnerAdapter(List<Item_Partner> item_partners, Context context) {
        this.item_partners = item_partners;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder_Partner onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemforpartner, null);
        RecyclerViewHolder_Partner viewHolder = new RecyclerViewHolder_Partner(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder_Partner holder, int position) {
        holder.img_Partner.setImageResource(item_partners.get(position).getiThumbnail());
        holder.txtName_Partner.setText(item_partners.get(position).getsName());

    }

    @Override
    public int getItemCount() {
        return this.item_partners.size();
    }
}
