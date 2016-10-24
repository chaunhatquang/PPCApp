package com.perfectproperties.app.ppc_app.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.perfectproperties.app.ppc_app.Adapter.SellsAdapter;
import com.perfectproperties.app.ppc_app.Other.Item_Sell;
import com.perfectproperties.app.ppc_app.R;
import com.perfectproperties.app.ppc_app.SellDatabaseOpenHelper;
import com.perfectproperties.app.ppc_app.SellsEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SellActivity extends Activity {
    private LinearLayoutManager layoutManager;
    private RecyclerView recyclerView;

    private List<SellsEntity> sellsList;
    ListView listView;
    SellsEntity sellsEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        /*setTitle("Ban");
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        try {
            List<Item_Sell> item_sells = getAllItem();
            layoutManager = new LinearLayoutManager(SellActivity.this);

            recyclerView.setLayoutManager(layoutManager);
            SellAdapter sellAdapter = new SellAdapter(item_sells, getApplicationContext());
            recyclerView.setAdapter(sellAdapter);
        } catch (Exception e) {
            Log.d("ERROR", e.toString());
        }*/
        listView = (ListView)findViewById(R.id.listSells);
        sellsList = getsellsList();
        SellsAdapter adapter = new SellsAdapter(this,R.layout.itemforsell,getsellsList());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try{sellsEntity = sellsList.get(position);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("sell",sellsEntity);
                    Intent i = new Intent(getApplicationContext(),DetailedProjectActivity.class);
                    i.putExtra("bundle",bundle);
                    startActivity(i);}
                catch (Exception e){
                    Toast.makeText(SellActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private List<SellsEntity> getsellsList() {
        List<SellsEntity> sellsList = new ArrayList<>();
        SellDatabaseOpenHelper db = new SellDatabaseOpenHelper(getApplicationContext());
        try {
            db.create();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(db.open()){
            sellsList = db.getListSells();
        }
        return sellsList;
    }

    private List<Item_Sell> getAllItem() {
        List<Item_Sell> itemSells = new ArrayList<Item_Sell>();
        itemSells.add(new Item_Sell("$ 500.000", "House", R.drawable.bg_buy));
        itemSells.add(new Item_Sell("$ 500.000", "House", R.drawable.bg_buy));
        itemSells.add(new Item_Sell("$ 500.000", "Villa", R.drawable.bg_buy));
        itemSells.add(new Item_Sell("$ 500.000", "Villa", R.drawable.bg_buy));
        itemSells.add(new Item_Sell("$ 500.000", "Villa", R.drawable.bg_buy));
        itemSells.add(new Item_Sell("$ 500.000", "Villa", R.drawable.bg_buy));
        return itemSells;
    }
}
