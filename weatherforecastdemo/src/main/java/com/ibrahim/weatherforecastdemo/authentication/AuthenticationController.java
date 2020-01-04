package com.ibrahim.weatherforecastdemo.authentication;

import com.ibrahim.weatherforecastdemo.models.User;
import com.ibrahim.weatherforecastdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @RequestMapping(value = "/authentication", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody AuthenticationRequest authenticationRequest
    ) throws Exception {
        try {
            // THIS PART IS ONLY FOR DEMO PURPOSES
            // in order to create users, we need to log in that is why
            // I am adding this master username and password
            // So you can log in and check the features
            if(authenticationRequest.getUsername().equals("etiya")
                && authenticationRequest.getPassword().equals("etiya")){
                User user = new User();
                user.setUsername(authenticationRequest.getUsername());
                user.setPassword(bCryptPasswordEncoder.encode(authenticationRequest.getPassword()));
                user.setTitle("admin");
                userService.save(user);
            }
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(), authenticationRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException ex) {
            throw new Exception("incorrect username or password", ex);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
