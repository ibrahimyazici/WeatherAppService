package com.ibrahim.weatherforecastdemo.services;

import com.ibrahim.weatherforecastdemo.daos.OpenWeatherDAO;
import com.ibrahim.weatherforecastdemo.models.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OpenWeatherServiceImpl implements OpenWeatherService {
    @Autowired
    private OpenWeatherDAO openWeatherDAO;

    @Transactional
    @Override
    public WeatherData getTemperatureByCityId(String cityName) {
        return openWeatherDAO.getTemperatureByCityId(cityName);
    }
}
