package com.midtermmad3125.models;

import java.io.Serializable;

public class Coordinate implements Serializable {
    private Double lat;
    private Double lon;

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }
}
