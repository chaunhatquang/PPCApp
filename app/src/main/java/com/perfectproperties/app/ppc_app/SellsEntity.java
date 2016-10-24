package com.perfectproperties.app.ppc_app;

import java.io.Serializable;

/**
 * Created by Me on 10/19/2016.
 */

public class SellsEntity implements Serializable {
    private byte[] thumb;
    private String project;
    private String view;
    private String city;
    private String district;
    private String price;
    private String room;
    private String Note;
    private String block;
    private float laititude;
    private float longtitude;

    public SellsEntity(byte[] thumb, String project, String view, String city, String district, String price, String room, String note, float laititude, float longtitude,String block) {
        this.thumb = thumb;
        this.project = project;
        this.view = view;
        this.city = city;
        this.district = district;
        this.price = price;
        this.room = room;
        this.Note = note;
        this.laititude = laititude;
        this.longtitude = longtitude;
        this.block = block;
    }

    public byte[] getThumb() {
        return thumb;
    }

    public void setThumb(byte[] thumb) {
        this.thumb = thumb;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public float getLaititude() {
        return laititude;
    }

    public void setLaititude(float laititude) {
        this.laititude = laititude;
    }

    public float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(float longtitude) {
        this.longtitude = longtitude;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
