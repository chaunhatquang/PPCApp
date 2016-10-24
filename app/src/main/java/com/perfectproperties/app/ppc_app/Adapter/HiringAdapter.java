package com.perfectproperties.app.ppc_app.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.perfectproperties.app.ppc_app.Other.Item_Hiring;
import com.perfectproperties.app.ppc_app.R;

import java.util.List;

/**
 * Created by haitr on 10/18/2016.
 */

public class HiringAdapter extends RecyclerView.Adapter<RecyclerViewHolder_Hiring> {
    private Context context;
    private List<Item_Hiring> item_hirings;

    public HiringAdapter(Context context, List<Item_Hiring> item_hirings) {
        this.context = context;
        this.item_hirings = item_hirings;
    }

    @Override
    public RecyclerViewHolder_Hiring onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_hiring, null);
        RecyclerViewHolder_Hiring viewHolder = new RecyclerViewHolder_Hiring(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder_Hiring holder, int position) {
        holder.img_Hiring.setImageResource(item_hirings.get(position).getiImage());
        holder.txtTitle.setText(item_hirings.get(position).getsName());

    }

    @Override
    public int getItemCount() {
        return this.item_hirings.size();
    }
}
