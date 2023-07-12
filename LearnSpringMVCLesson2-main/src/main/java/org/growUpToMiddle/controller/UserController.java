package org.growUpToMiddle.controller;

import lombok.RequiredArgsConstructor;
import org.growUpToMiddle.dao.UserDaoImpl;
import org.growUpToMiddle.model.User;
import org.growUpToMiddle.service.UserService;
import org.growUpToMiddle.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userServiceImpl;
    @GetMapping("/users")
    public String getUsersPage(Model model) {
        model.addAttribute("users", userServiceImpl.getAllUsers());
        return "/users";
    }

    @PostMapping("/users")
    public String addUser(User user) {
        userServiceImpl.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{user-id}")
    public String getUserPage(@PathVariable("user-id") Long id, Model model) {
        model.addAttribute("user", userServiceImpl.getUserById(id));
        return "/user";
    }

    @PostMapping("/user/{id}/update")
    public String updateUser(@PathVariable("id") Long userId,User user) {
        userServiceImpl.updateUser(userId,user);
        return "redirect:/user/{id}" + userId;
    }

    @GetMapping("/users/{id}/delete")
    public String updateUser(@PathVariable("id") Long userId) {
        userServiceImpl.deleteUser(userId);
        return "redirect:/users";
    }

}
