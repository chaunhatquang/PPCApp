package com.perfectproperties.app.ppc_app.Other;

/**
 * Created by haitr on 10/17/2016.
 */

public class Item_Partner {
    private String sName;
    private int iThumbnail;

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getiThumbnail() {
        return iThumbnail;
    }

    public void setiThumbnail(int iThumbnail) {
        this.iThumbnail = iThumbnail;
    }

    public Item_Partner(String sName, int iThumbnail) {

        this.sName = sName;
        this.iThumbnail = iThumbnail;
    }
}
