package com.ibrahim.weatherforecastdemo.controllers;

import com.ibrahim.weatherforecastdemo.models.City;
import com.ibrahim.weatherforecastdemo.models.ImmediateCity;
import com.ibrahim.weatherforecastdemo.services.CityService;
import com.ibrahim.weatherforecastdemo.services.OpenWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<City> get() {
        return cityService.getAllCities();
    }

    @PostMapping("/addCities")
    public void save(@RequestBody ImmediateCity cities){
        for(String city: cities.getCities()){
            cityService.save(new City(city));
        }
    }

    @PostMapping("/addCity")
    public void save(@RequestBody City city){
        cityService.save(city);
    }

    @DeleteMapping("/city/{id}")
    public String delete(@PathVariable long id){
        cityService.deleteCityById(id);
        return "City with id " + id + " is deleted";
    }

}
