package com.midtermmad3125.models;

import java.io.Serializable;

public class City implements Serializable {
    public long id;
    public String name;
    public Coordinate coordinate=new Coordinate();
    public String countryCode;
    public String population;
}
