package com.ibrahim.weatherforecastdemo.authentication;

import com.ibrahim.weatherforecastdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<com.ibrahim.weatherforecastdemo.models.User> users = userService.getAllUsers();
        com.ibrahim.weatherforecastdemo.models.User user = users.stream().filter(u -> username.equals(u.getUsername()))
                .findAny().orElse(null);
        String uName = null;
        String pWord = null;
        if(user != null){
            uName = user.getUsername();
            pWord = user.getPassword();
        }
        return new User(uName, pWord, new ArrayList<>());
    }
}
