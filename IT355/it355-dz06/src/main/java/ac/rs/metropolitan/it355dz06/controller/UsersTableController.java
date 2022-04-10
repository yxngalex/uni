package ac.rs.metropolitan.it355dz06.controller;

import ac.rs.metropolitan.it355dz06.model.UsersTable;
import ac.rs.metropolitan.it355dz06.service.UsersTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UsersTableController {
    private final UsersTableService usersTableService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String newUser(Model model) {
        UsersTable user = new UsersTable();
        model.addAttribute("user", user);
        return "saveUser";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") UsersTable user) {
        UsersTable test = usersTableService.findByUsername(user.getUsername());
        if (test == null) {
            usersTableService.save(user);
            return "redirect:/exams";
        } else {
            return "redirect:/saveUser";
        }
    }
}
