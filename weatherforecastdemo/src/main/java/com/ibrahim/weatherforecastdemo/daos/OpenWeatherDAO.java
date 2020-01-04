package com.ibrahim.weatherforecastdemo.daos;

import com.ibrahim.weatherforecastdemo.models.WeatherData;

public interface OpenWeatherDAO {
    WeatherData getTemperatureByCityId(String cityName);
}
