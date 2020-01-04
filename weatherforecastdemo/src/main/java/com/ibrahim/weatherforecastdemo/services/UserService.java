package com.ibrahim.weatherforecastdemo.services;

import com.ibrahim.weatherforecastdemo.models.User;

import java.util.List;

public interface UserService {
    User getUserById(long id);
    List<User> getAllUsers();
    void save(User user);
    void deleteUserById(long id);
}
