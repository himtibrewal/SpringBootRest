package com.itexpert.springbootrest.controller;

import com.itexpert.springbootrest.entity.User;
import com.itexpert.springbootrest.sequrity.LoginResult;
import com.itexpert.springbootrest.dto.LoginDto;
import com.itexpert.springbootrest.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResult login(@RequestBody LoginDto loginDto) {
        return authService.login(loginDto);
    }

    @PostMapping("/register")
    public User login(@RequestBody User user) {
        return authService.register(user);
    }



}
