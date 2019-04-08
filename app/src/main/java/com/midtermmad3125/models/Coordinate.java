package com.midtermmad3125.models;

public class Coordinate {
    private Double lat;
    private Double lon;

    public Coordinate(Double lat, Double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
