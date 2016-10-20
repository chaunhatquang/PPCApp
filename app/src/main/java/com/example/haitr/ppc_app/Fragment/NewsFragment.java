package com.example.haitr.ppc_app.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.haitr.ppc_app.Adapter.NewsAdapter;
import com.example.haitr.ppc_app.Other.Item_News;
import com.example.haitr.ppc_app.R;
import com.example.haitr.ppc_app.SellDatabaseOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    private LinearLayoutManager layoutManager;
    private RecyclerView recyclerView;
    private SellDatabaseOpenHelper db;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        // Inflate the layout for this fragment
        getActivity().setTitle("Tin Tuc");
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER;
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_News);
        try {
            List<Item_News> item_newses = getAllItem();
            layoutManager = new LinearLayoutManager(getContext());

            recyclerView.setLayoutManager(layoutManager);
            NewsAdapter newsAdapter = new NewsAdapter(item_newses, getContext().getApplicationContext());
            recyclerView.setAdapter(newsAdapter);
            recyclerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Tesst", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            Log.d("ERROR", e.toString());
        }

        return view;
    }

    private List<Item_News> getAllItem() {
        List<Item_News> item_newses = new ArrayList<Item_News>();
        if(db.open()){
            item_newses = db.getListNew();
        }
        return item_newses;
    }

}
