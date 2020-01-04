package com.ibrahim.weatherforecastdemo.controllers;

import com.ibrahim.weatherforecastdemo.models.QueryLog;
import com.ibrahim.weatherforecastdemo.models.User;
import com.ibrahim.weatherforecastdemo.models.WeatherData;
import com.ibrahim.weatherforecastdemo.services.OpenWeatherService;
import com.ibrahim.weatherforecastdemo.services.QueryLogService;
import com.ibrahim.weatherforecastdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService userService;

    @Autowired
    private OpenWeatherService openWeatherService;

    @Autowired
    private QueryLogService queryLogService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/user")
    public User save(@RequestBody User user) {
        user.setPassword(
            bCryptPasswordEncoder.encode(user.getPassword())
        );
        userService.save(user);
        return user;
    }

    @GetMapping("/users")
    public List<User> get() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User get(@PathVariable long id) {
        User user = userService.getUserById(id);
        if(user == null){
            throw new RuntimeException("No user with given id");
        }
        return user;
    }

    @GetMapping("/user/{id}/getTemperature/{cityName}")
    public WeatherData getTemperature(@PathVariable("id") long id,
                                      @PathVariable("cityName") String cityName,
                                      @RequestHeader("username") String username) {
        long start = System.currentTimeMillis();
        WeatherData weatherData = openWeatherService.getTemperatureByCityId(cityName);
        long timeSpent = System.currentTimeMillis() - start;
        QueryLog queryLog = new QueryLog(
            username,
            cityName,
            weatherData.getLocaltime(),
            request.getRemoteAddr(),
            weatherData.getTemperature(),
                (int)timeSpent,
            weatherData.isStatus()
        );
        queryLogService.save(queryLog);
        return weatherData;
    }

    @PutMapping("/user")
    public User update(@RequestBody User user) {
        user.setPassword(
                bCryptPasswordEncoder.encode(user.getPassword())
        );
        userService.save(user);
        return user;
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable long id) {
        userService.deleteUserById(id);
        return "User with id " + id + " is deleted";
    }
}
