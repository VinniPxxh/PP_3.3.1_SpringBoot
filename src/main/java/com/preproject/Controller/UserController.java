package com.preproject.Controller;

import com.preproject.model.User;
import com.preproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/create-user")
    public String createUserForm(User user) {
        return "create-user";
    }

    @PostMapping
    public String createUser(User user) {
        userService.addOrUpdateUser(user);
        return "redirect:/users";
    }
}
