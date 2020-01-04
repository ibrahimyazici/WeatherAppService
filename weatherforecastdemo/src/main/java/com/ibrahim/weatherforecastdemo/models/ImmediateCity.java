package com.ibrahim.weatherforecastdemo.models;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used for getting the cities names ready
 * for db operations
 * It holds the list of cities as string
 */
public class ImmediateCity {
    List<String> cities;

    public ImmediateCity() {
        this.cities = new ArrayList<>();
    }

    public List<String> getCities() {
        return cities;
    }
}
