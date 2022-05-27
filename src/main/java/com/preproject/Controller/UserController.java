package com.preproject.Controller;

import com.preproject.model.User;
import com.preproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{id}/update-user")
    public String formUpdateUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "update-user";
    }
    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.addOrUpdateUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/remove/{id}")
    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "update-user";
    }
}
