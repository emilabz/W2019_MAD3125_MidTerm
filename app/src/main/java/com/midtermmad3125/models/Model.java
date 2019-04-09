package com.midtermmad3125.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Model implements Serializable {
    public City city=new City();
    public List<WeatherList> wlist=new ArrayList<WeatherList>();
}
