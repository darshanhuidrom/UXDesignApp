
package com.globizs.uxdesignapp.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Spots {

    @SerializedName("spots")
    @Expose
    private List<Spot> spots = null;

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

}
