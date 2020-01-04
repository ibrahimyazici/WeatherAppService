package com.ibrahim.weatherforecastdemo.daos;

import com.ibrahim.weatherforecastdemo.models.City;
import com.ibrahim.weatherforecastdemo.models.User;

import java.util.List;

public interface CityDAO {
    City getCityById(long id);
    List<City> getAllCities();
    void save(City city);
    void deleteCityById(long id);
}
