package com.mendes.controller;

import com.mendes.entity.User;
import com.mendes.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mendesmustafa on 11.02.2021.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/user/book/list";
    }

    @GetMapping("/addUser")
    public String add(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/userForm";
    }
}
