package com.globizs.uxdesignapp.modal;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Spot {

    @SerializedName("spot_name")
    @Expose
    private String spotName;
    @SerializedName("Info")
    @Expose
    private String info;
    @SerializedName("des")
    @Expose
    private String des;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("long")
    @Expose
    private String _long;
    @SerializedName("spot_no")
    @Expose
    private String spotNo;

    private String imagePath;
    private LatLng latLng;
    private String audioFileName;
    public Spot(String name, String imagePath,LatLng latLng) {
        this.spotName = name;
        this.imagePath = imagePath;
        this.latLng=latLng;
    }

    public Spot(String name, String imagePath) {
        this.spotName = name;
        this.imagePath = imagePath;
    }


    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLong() {
        return _long;
    }

    public void setLong(String _long) {
        this._long = _long;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public LatLng getLatLng() {
       return this.latLng;
    }

    public void setLatLng(LatLng latLng) {
       this.latLng=latLng;
    }

    public String getAudioFileName() {
        return audioFileName;
    }

    public void setAudioFileName(String audioFileName) {
        this.audioFileName = audioFileName;
    }

    public String get_long() {
        return _long;
    }

    public void set_long(String _long) {
        this._long = _long;
    }

    public String getSpotNo() {
        return spotNo;
    }

    public void setSpotNo(String spotNo) {
        this.spotNo = spotNo;
    }
}