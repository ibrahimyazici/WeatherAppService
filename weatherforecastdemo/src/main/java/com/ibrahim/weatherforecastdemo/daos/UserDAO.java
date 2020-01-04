package com.ibrahim.weatherforecastdemo.daos;

import com.ibrahim.weatherforecastdemo.models.User;

import java.util.List;

public interface UserDAO {
    User getUserById(long id);
    List<User> getAllUsers();
    void save(User user);
    void deleteUserById(long id);
}