package com.metropolitan.it355dz08.controller;

import com.metropolitan.it355dz08.entity.User;
import com.metropolitan.it355dz08.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest-user")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok(userService.add(user));
    }

    @PutMapping()
    public ResponseEntity<User> update(@RequestBody User user){
        return ResponseEntity.ok(userService.add(user));
    }

    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable Integer userId){
        List<User> usersList = userService.getAllUsers();
        for(User user : usersList){
            if(user.getId() == userId){
                userService.delete(user);
            }
        }
    }
}