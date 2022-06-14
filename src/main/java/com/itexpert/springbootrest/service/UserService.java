package com.itexpert.springbootrest.service;

import com.itexpert.springbootrest.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Long id);

    List<User> getAllUser();

    User updateUser(Long id, User user);

    User saveUser(User user);

    void deleteUser(Long id);
}
