package com.example.haitr.ppc_app.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haitr.ppc_app.Adapter.HiringAdapter;
import com.example.haitr.ppc_app.Other.Item_Hiring;
import com.example.haitr.ppc_app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HiringFrament extends Fragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    public HiringFrament() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hiring, container, false);
        // Inflate the layout for this fragment
        //recycler_hiring
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_hiring);
        try {
            List<Item_Hiring> item_hirings = getAllItem();
            layoutManager = new LinearLayoutManager(getContext());

            recyclerView.setLayoutManager(layoutManager);
            HiringAdapter hiringAdapter = new HiringAdapter(getContext().getApplicationContext(), item_hirings);
            recyclerView.setAdapter(hiringAdapter);
        } catch (Exception e) {
            Log.d("ERROR", e.toString());
        }
        return view;
    }

    private List<Item_Hiring> getAllItem() {
        List<Item_Hiring> item_hirings = new ArrayList<Item_Hiring>();
        item_hirings.add(new Item_Hiring("Tuyển Nhân Viên Thiết Kế \\nHạn nộp: 1/10/2016", R.drawable.bg_hiring));
        item_hirings.add(new Item_Hiring("Tuyển Nhân Viên Thiết Kế \\nHạn nộp: 1/10/2016", R.drawable.bg_hiring1));
        return item_hirings;
    }

}
