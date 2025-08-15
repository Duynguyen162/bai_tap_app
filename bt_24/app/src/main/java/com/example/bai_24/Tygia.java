package com.example.bai_24;

import android.graphics.Bitmap;

public class Tygia {
    private String type;
    private String imageurl;
    private Bitmap bitmap;
    private String muatienmat;
    private String muack;

    public Tygia(String type, String imageurl, Bitmap bitmap, String muatienmat, String muack, String bantuenmat, String banck) {
        this.type = type;
        this.imageurl = imageurl;
        this.bitmap = bitmap;
        this.muatienmat = muatienmat;
        this.muack = muack;
        this.bantuenmat = bantuenmat;
        this.banck = banck;

    }

    public String getBanck() {
        return banck;
    }

    public void setBanck(String banck) {
        this.banck = banck;
    }

    public String getBantuenmat() {
        return bantuenmat;
    }

    public void setBantuenmat(String bantuenmat) {
        this.bantuenmat = bantuenmat;
    }

    public String getMuack() {
        return muack;
    }

    public void setMuack(String muack) {
        this.muack = muack;
    }

    public String getMuatienmat() {
        return muatienmat;
    }

    public void setMuatienmat(String muatienmat) {
        this.muatienmat = muatienmat;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    private String bantuenmat;
    private String banck;

    public Tygia() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}