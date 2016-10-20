package com.example.haitr.ppc_app.Other;

import java.io.Serializable;

/**
 * Created by Me on 10/18/2016.
 */

public class Model implements Serializable {
    int id;
    String Domain;
    byte [] Thumb;
    String Des,Title,Address,Email,Hotline;
    int idloainha,idloaigiaodich;
    String ChuDauTu;
    double dientich;
    int socan;
    String bangiao,loaicanho,link,Tienich,HinhThucSoHuu,TinhTrang;
    float lat,lon;

    public Model(int id, String domain, byte[] thumb, String des, String title, String address, String email, String hotline, int idloainha, int idloaigiaodich,
                 String chuDauTu, double dientich, int socan, String bangiao, String loaicanho, String link, String tienich, String hinhThucSoHuu, String tinhTrang,
                 float lat, float lon)
    {
        this.id = id;
        Domain = domain;
        Thumb = thumb;
        Des = des;
        Title = title;
        Address = address;
        Email = email;
        Hotline = hotline;
        this.idloainha = idloainha;
        this.idloaigiaodich = idloaigiaodich;
        ChuDauTu = chuDauTu;
        this.dientich = dientich;
        this.socan = socan;
        this.bangiao = bangiao;
        this.loaicanho = loaicanho;
        this.link = link;
        Tienich = tienich;
        HinhThucSoHuu = hinhThucSoHuu;
        TinhTrang = tinhTrang;
        this.lat = lat;
        this.lon = lon;
    }

    /*public Model(int id, String des, String title, String address, String email, String hotline) {
        this.id = id;
        Des = des;
        Title = title;
        Address = address;
        Email = email;
        Hotline = hotline;
    }*/

    public Model(int id, byte[] thumb, String des, String title, String address, String email, String hotline) {
        this.id = id;
        Thumb = thumb;
        Des = des;
        Title = title;
        Address = address;
        Email = email;
        Hotline = hotline;
    }

    public Model(int id, byte[] thumb, String des, String title, String address, String email, String hotline, float lat, float lon) {
        this.id = id;
        Thumb = thumb;
        Des = des;
        Title = title;
        Address = address;
        Email = email;
        Hotline = hotline;
        this.lat = lat;
        this.lon = lon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomain() {
        return Domain;
    }

    public void setDomain(String domain) {
        Domain = domain;
    }

    public byte[] getThumb() {
        return Thumb;
    }

    public void setThumb(byte[] thumb) {
        Thumb = thumb;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getHotline() {
        return Hotline;
    }

    public void setHotline(String hotline) {
        Hotline = hotline;
    }

    public int getIdloainha() {
        return idloainha;
    }

    public void setIdloainha(int idloainha) {
        this.idloainha = idloainha;
    }

    public int getIdloaigiaodich() {
        return idloaigiaodich;
    }

    public void setIdloaigiaodich(int idloaigiaodich) {
        this.idloaigiaodich = idloaigiaodich;
    }

    public String getChuDauTu() {
        return ChuDauTu;
    }

    public void setChuDauTu(String chuDauTu) {
        ChuDauTu = chuDauTu;
    }

    public double getDientich() {
        return dientich;
    }

    public void setDientich(double dientich) {
        this.dientich = dientich;
    }

    public int getSocan() {
        return socan;
    }

    public void setSocan(int socan) {
        this.socan = socan;
    }

    public String getBangiao() {
        return bangiao;
    }

    public void setBangiao(String bangiao) {
        this.bangiao = bangiao;
    }

    public String getLoaicanho() {
        return loaicanho;
    }

    public void setLoaicanho(String loaicanho) {
        this.loaicanho = loaicanho;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTienich() {
        return Tienich;
    }

    public void setTienich(String tienich) {
        Tienich = tienich;
    }

    public String getHinhThucSoHuu() {
        return HinhThucSoHuu;
    }

    public void setHinhThucSoHuu(String hinhThucSoHuu) {
        HinhThucSoHuu = hinhThucSoHuu;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        TinhTrang = tinhTrang;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }
}
