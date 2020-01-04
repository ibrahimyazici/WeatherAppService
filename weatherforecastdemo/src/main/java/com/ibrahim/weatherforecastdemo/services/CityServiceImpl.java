package com.ibrahim.weatherforecastdemo.services;

import com.ibrahim.weatherforecastdemo.daos.CityDAO;
import com.ibrahim.weatherforecastdemo.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDAO cityDAO;

    @Transactional
    @Override
    public City getCityById(long id) {
        return cityDAO.getCityById(id);
    }

    @Transactional
    @Override
    public List<City> getAllCities() {
        return cityDAO.getAllCities();
    }

    @Transactional
    @Override
    public void save(City city) {
        cityDAO.save(city);
    }

    @Transactional
    @Override
    public void deleteCityById(long id) {
        cityDAO.deleteCityById(id);
    }
}
