package com.metropolitan.it355dz08.service;

import com.metropolitan.it355dz08.entity.User;

import java.util.List;

public interface UserService {
    User add(User user);
    List<User> getAllUsers();
    User getUserByUsername(String username);
    void update(User user);
    void delete(User user);
}
