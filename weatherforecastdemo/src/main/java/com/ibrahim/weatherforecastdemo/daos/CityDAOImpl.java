package com.ibrahim.weatherforecastdemo.daos;

import com.ibrahim.weatherforecastdemo.models.City;
import com.ibrahim.weatherforecastdemo.models.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CityDAOImpl implements CityDAO{
    @Autowired
    private EntityManager entityManager;

    @Override
    public City getCityById(long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        City city = currentSession.get(City.class, id);
        return city;
    }

    @Override
    public List<City> getAllCities() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<City> query = currentSession.createQuery("from City", City.class);
        List<City> cities = query.getResultList();
        return cities;
    }

    @Override
    public void save(City city) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(city);
    }


    @Override
    public void deleteCityById(long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        City city = currentSession.get(City.class, id);
        currentSession.delete(city);
    }
}
