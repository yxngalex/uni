package com.metropolitan.it355dz08.controller;

import com.metropolitan.it355dz08.entity.User;
import com.metropolitan.it355dz08.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String viewAllUsers(Model model) {
        model.addAttribute("getUsers", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping(value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id){
        List<User> usersList = userService.getAllUsers();
        for(User user : usersList){
            if(user.getId() == id){
                userService.delete(user);
            }
        }
        return "redirect:/";
    }

    @PostMapping("/saveUser")
    public String saveEmployee(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping("/showEditUserForm/{id}")
    public String showEditEmployeeForm(@PathVariable Integer id, Model model){
        List<User> usersList = userService.getAllUsers();

        for(User user : usersList){
            if(user.getId() == id){
                model.addAttribute("user", user);
            }
        }
        return "edit_user";
    }
}