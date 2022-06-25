package com.metropolitan.it355dz08.security;

import com.metropolitan.it355dz08.entity.User;
import com.metropolitan.it355dz08.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);

        return new com.metropolitan.it355dz08.security.UserDetails(user);
    }
}