package com.midtermmad3125.models;

import java.io.Serializable;

public class WeatherList implements Serializable {
    public Temp t;
    public long dt;
    public Double pressure;
    public int humidity;
    public Weather w;
    public Double speed;
    public int deg;
    public int clouds;
    public Double rain;
    public WeatherList(){

    }
    public WeatherList(Temp t, long dt, Double pressure, int humidity, Weather w, Double speed, int deg, int clouds, Double rain) {
        this.t = t;
        this.dt = dt;
        this.pressure = pressure;
        this.humidity = humidity;
        this.w = w;
        this.speed = speed;
        this.deg = deg;
        this.clouds = clouds;
        this.rain = rain;
    }
}
