package com.ibrahim.weatherforecastdemo.services;

import com.ibrahim.weatherforecastdemo.models.City;

import java.util.List;

public interface CityService {
    City getCityById(long id);
    List<City> getAllCities();
    void save(City city);
    void deleteCityById(long id);
}
