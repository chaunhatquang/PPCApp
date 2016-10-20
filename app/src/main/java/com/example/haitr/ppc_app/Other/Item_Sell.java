package com.example.haitr.ppc_app.Other;

/**
 * Created by haitr on 10/16/2016.
 */

public class Item_Sell {
    private String sPrice;
    private String sType;
    private int iThumbnail;

    public String getsPrice() {
        return sPrice;
    }

    public void setsPrice(String sPrice) {
        this.sPrice = sPrice;
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }

    public int getsThumbnail() {
        return iThumbnail;
    }

    public void setsThumbnail(int iThumbnail) {
        this.iThumbnail = iThumbnail;
    }

    public Item_Sell(String sPrice, String sType, int iThumbnail) {

        this.sPrice = sPrice;
        this.sType = sType;
        this.iThumbnail = iThumbnail;
    }


}
