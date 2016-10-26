package com.perfectproperties.app.ppc_app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.perfectproperties.app.ppc_app.Activity.BuyActivity;
import com.perfectproperties.app.ppc_app.Activity.SellActivity;
import com.perfectproperties.app.ppc_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button btnSell, btnBuy;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().setTitle(R.string.item_home);
        // Inflate the layout for this fragment
        btnBuy = (Button) view.findViewById(R.id.button_buy);
        btnSell = (Button) view.findViewById(R.id.button_sell);
        btnSell.setOnClickListener(this);
        btnBuy.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_sell:
                Intent sell_intent = new Intent(getActivity(), SellActivity.class);
                startActivity(sell_intent);
                break;
            case R.id.button_buy:
                Intent buy_intent = new Intent(getContext(), BuyActivity.class);
                startActivity(buy_intent);
                break;

            default:
                break;
        }
    }
}
