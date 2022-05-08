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
    public String getAllUsers(Model model) {
        model.addAttribute("getUsers", userService.getAll());
        return "index";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add_user";
    }

    @DeleteMapping(value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id) {
        List<User> usersList = userService.getAll();
        for (User user : usersList) {
            if (user.getId().equals(id)) {
                userService.delete(user);
            }
        }
        return "redirect:/";
    }

    @PostMapping("/saveUser")
    public String saveEmployee(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping("/showEditUserForm/{id}")
    public String showEditEmployeeForm(@PathVariable Integer id, Model model) {
        List<User> usersList = userService.getAll();

        for (User user : usersList) {
            if (user.getId().equals(id)) {
                model.addAttribute("user", user);
            }
        }
        return "edit_user";
    }

}
