package com.metropolitan.it355dz08.service.impl;

import com.metropolitan.it355dz08.entity.User;
import com.metropolitan.it355dz08.repository.UserRepository;
import com.metropolitan.it355dz08.service.UserRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRestServiceImpl implements UserRestService {
    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer userId) {
        userRepository.deleteById(userId);
    }
}
