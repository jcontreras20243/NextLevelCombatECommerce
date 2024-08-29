package com.contrerasjose.ecommercemanagement.ecommercemgt.controller;

import com.contrerasjose.ecommercemanagement.ecommercemgt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.contrerasjose.ecommercemanagement.ecommercemgt.entity.User;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/Users/getUsers")
    public String getUsers(Model model) {
        model.addAttribute("usersList", userService.getAllUsers());
        return "Users/ViewUser";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "Users/AddUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(User user) {
        userService.saveOrUpdateUser(user);
        return "redirect:/Users/getUsers";
    }

    @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "Users/EditUser";
    }
    @PutMapping("editSaveUser")
    public String editSaveUser(@ModelAttribute User user) {
        userService.saveOrUpdateUser(user);
        return "redirect:/Users/getUsers";
    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/Users/getUsers";
    }
}

