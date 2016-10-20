package com.example.haitr.ppc_app.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haitr.ppc_app.Adapter.PartnerAdapter;
import com.example.haitr.ppc_app.Other.Item_Partner;
import com.example.haitr.ppc_app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PartnerFragment extends Fragment {
    private LinearLayoutManager layoutManager;
    private RecyclerView recyclerView;


    public PartnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_partner, container, false);
        // Inflate the layout for this fragment
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_Partner);
        try {
            List<Item_Partner> item_partners = getAllItem();
            layoutManager = new LinearLayoutManager(getContext());

            recyclerView.setLayoutManager(layoutManager);
            PartnerAdapter partnerAdapter = new PartnerAdapter(item_partners, getContext().getApplicationContext());
            recyclerView.setAdapter(partnerAdapter);
        } catch (Exception e) {
            Log.d("ERROR", e.toString());
        }
        return view;
    }

    private List<Item_Partner> getAllItem() {
        List<Item_Partner> item_partners = new ArrayList<Item_Partner>();
        item_partners.add(new Item_Partner("Capital Land", R.drawable.bg_capital));
        item_partners.add(new Item_Partner("Centurion International", R.drawable.bg_centurion));
        item_partners.add(new Item_Partner("Collier International", R.drawable.bg_collier));
        item_partners.add(new Item_Partner("CNC Group", R.drawable.bg_cnc));
        item_partners.add(new Item_Partner("FLC Company", R.drawable.bg_flc));
        return item_partners;
    }

}
