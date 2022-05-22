package com.metropolitan.it355dz08.service;

import com.metropolitan.it355dz08.entity.User;

import java.util.List;

public interface UserRestService {
    List<User> findAll();

    User saveUser(User user);

    User updateUser(User user);

    void deleteById(Integer userId);
}
