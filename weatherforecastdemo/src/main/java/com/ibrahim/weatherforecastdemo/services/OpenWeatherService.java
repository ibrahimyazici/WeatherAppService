package com.ibrahim.weatherforecastdemo.services;

import com.ibrahim.weatherforecastdemo.models.WeatherData;

public interface OpenWeatherService {
    WeatherData getTemperatureByCityId(String cityName);
}
