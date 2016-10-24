package com.perfectproperties.app.ppc_app.Other;

/**
 * Created by haitr on 10/18/2016.
 */

public class Item_Hiring {
    private String sName;
    private int iImage;

    public Item_Hiring(String sName, int iImage) {
        this.sName = sName;
        this.iImage = iImage;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getiImage() {
        return iImage;
    }

    public void setiImage(int iImage) {
        this.iImage = iImage;
    }
}
