package com.perfectproperties.app.ppc_app.Other;

/**
 * Created by haitr on 10/18/2016.
 */

public class Item_Hiring {
    private String sName;
    private String sDeadline;
    private int iImage;

    public Item_Hiring(String sName, String sDeadline, int iImage) {
        this.sName = sName;
        this.sDeadline = sDeadline;
        this.iImage = iImage;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsDeadline() {
        return sDeadline;
    }

    public void setsDeadline(String sDeadline) {
        this.sDeadline = sDeadline;
    }

    public int getiImage() {
        return iImage;
    }

    public void setiImage(int iImage) {
        this.iImage = iImage;
    }
}
