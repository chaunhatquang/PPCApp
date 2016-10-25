package com.perfectproperties.app.ppc_app.Other;

/**
 * Created by haitr on 10/17/2016.
 */

public class Item_Partner {
    private String name;
    private int img;
    private String link;

    public Item_Partner(String name, int img, String link) {
        this.name = name;
        this.img = img;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
