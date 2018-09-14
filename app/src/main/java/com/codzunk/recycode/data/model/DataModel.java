package com.codzunk.recycode.data.model;

public class DataModel {

    private int imgResId;
    private String imgTitle;
    private int thumbNail;

    public DataModel() {
    }

    public String getImgTitle() {
        return imgTitle;
    }

    public void setImgTitle(String imgTitle) {
        this.imgTitle = imgTitle;
    }

    public int getImgResId() {
        return imgResId;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }

    public int getThumbNail() {
        return thumbNail;
    }

    public void setThumbNail(int thumbNail) {
        this.thumbNail = thumbNail;
    }
}
