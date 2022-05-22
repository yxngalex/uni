package com.metropolitan.it355dz08.controller;

import com.metropolitan.it355dz08.entity.User;
import com.metropolitan.it355dz08.service.UserRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {
    private final UserRestService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable Integer userId) {
        List<User> usersList = userService.findAll();
        for (User user : usersList) {
            if (user.getId() == userId) {
                userService.deleteById(userId);
            }
        }
    }
}
