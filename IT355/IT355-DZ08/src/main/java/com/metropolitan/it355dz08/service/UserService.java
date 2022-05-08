package com.metropolitan.it355dz08.service;

import com.metropolitan.it355dz08.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> getAll();

    void update(User user);

    void delete(User user);
}
