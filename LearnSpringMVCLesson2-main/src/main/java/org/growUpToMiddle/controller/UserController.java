package org.growUpToMiddle.controller;

import lombok.RequiredArgsConstructor;
import org.growUpToMiddle.dao.UserDaoImpl;
import org.growUpToMiddle.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserDaoImpl userDao;
    @GetMapping("/users")
    public String getUsersPage(Model model) {
        model.addAttribute("users", userDao.getAllUsers());
        return "/users";
    }

    @PostMapping("/users")
    public String addUser(User user) {
        userDao.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{user-id}")
    public String getUserPage(@PathVariable("user-id") Long id, Model model) {
        model.addAttribute("user", userDao.getUserById(id));
        return "/user";
    }

    @PostMapping("/users/{user-id}/update")
    public String updateUser(@PathVariable("user-id") Long userId,User user) {
        userDao.updateUser(userId,user);
        return "redirect:/users/" + userId;
    }

    @GetMapping("/users/{user-id}/delete")
    public String deleteUser(@PathVariable("user-id") Long userId) {
        userDao.deleteUser(userId);
        return "redirect:/users/";
    }

}
