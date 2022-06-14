package com.itexpert.springbootrest.service;

import com.itexpert.springbootrest.entity.User;
import com.itexpert.springbootrest.sequrity.LoginResult;
import com.itexpert.springbootrest.dto.LoginDto;

public interface AuthService {

    LoginResult login(LoginDto loginDto);

    User register(User user);

}
