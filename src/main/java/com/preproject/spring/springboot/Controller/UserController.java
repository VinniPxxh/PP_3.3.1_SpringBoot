package com.preproject.spring.springboot.Controller;

import com.preproject.spring.springboot.model.User;
import com.preproject.spring.springboot.service.UserService;
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

    @PostMapping("/user-create")
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
    public String updateUser(@ModelAttribute("user") User user) {
        userService.addOrUpdateUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/user-delete/{id}")
    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable Long id) {
        userService.deleteById(userService.getUserById(id));
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "update-user";
    }
}
