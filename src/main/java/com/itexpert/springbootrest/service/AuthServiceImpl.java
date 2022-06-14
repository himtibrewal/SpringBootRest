package com.itexpert.springbootrest.service;


import com.itexpert.springbootrest.sequrity.JwtHelper;
import com.itexpert.springbootrest.sequrity.LoginResult;
import com.itexpert.springbootrest.dto.LoginDto;
import com.itexpert.springbootrest.entity.User;
import com.itexpert.springbootrest.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtHelper jwtHelper;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           JwtHelper jwtHelper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtHelper = jwtHelper;

    }

    @Override
    public LoginResult login(LoginDto loginDto) {
        User userDetails = userRepository.findAllByUsername(loginDto.getUsername());
        if (passwordEncoder.matches(loginDto.getPassword(), userDetails.getPassword())) {
            Map<String, String> claims = new HashMap<>();
            claims.put("username", userDetails.getUsername());
            String authorities = "hello";
            claims.put("authorities", authorities);
            claims.put("userId", String.valueOf(userDetails.getId()));
            String jwt = jwtHelper.createJwtForClaims(userDetails.getUsername(), claims);
            userRepository.updateToken(jwt, userDetails.getId());
            return new LoginResult(jwt);
        }
        return null;
    }

    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User updatedUser = userRepository.save(user);
        updatedUser.setPassword(user.getPassword());
        return updatedUser;
    }
}
