package com.userservice.service;

import com.userservice.entity.User;

import java.util.List;

public interface IUserService {
    User createUser(User user);

    List<User> getAllUsers();

    List<User> getUserByNameOrCity(String firstName, String lastName, String city);
}
