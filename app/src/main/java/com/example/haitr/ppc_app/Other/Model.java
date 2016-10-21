package com.example.haitr.ppc_app.Other;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Me on 10/18/2016.
 */

public class Model implements Serializable {
    int id;
    String Project;
    String Price,view,city,district;
    int badRoom;
    String note,lat,lon;


    byte [] Thumb;

    public int getBadRoom() {
        return badRoom;
    }

    public void setBadRoom(int badRoom) {
        this.badRoom = badRoom;
    }

    public Model(int id, String project, String price, String view, String city, String district, int badRoom, String note, String lon, String lat, byte[] thumb) {
        this.id = id;
        Project = project;
        Price = price;
        this.view = view;
        this.city = city;
        this.district = district;
        this.badRoom = badRoom;
        this.note = note;
        this.lon = lon;
        this.lat = lat;
        Thumb = thumb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProject() {
        return Project;
    }

    public void setProject(String project) {
        Project = project;
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

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }



    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public byte[] getThumb() {
        return Thumb;
    }

    public void setThumb(byte[] thumb) {
        Thumb = thumb;
    }
}
