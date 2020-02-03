package com.vcprojects.tcontrol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vcprojects.tcontrol.model.User;
import com.vcprojects.tcontrol.service.UserService;

@Controller
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/listUsers")
    public String listUsers(Model theModel) {
        List < User > theUsers = userService.getUsers();
        theModel.addAttribute("users", theUsers);
        return "index";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model theModel) {
        User theUser = new User();
        theModel.addAttribute("user", theUser);
        return "registration";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User theUser) {
        userService.saveUser(theUser);
        return "redirect:/";
    }

    @GetMapping("/authorization")
    public String showAuthorizationForm(Model theModel) {
        User theUser = new User();
        theModel.addAttribute("user", theUser);
        return "authorization";
    }

    @GetMapping("/updateUser")
    public String updateUserForm(@RequestParam("userId") int theId, Model theModel) {
        User theUser = userService.getUser(theId);
        theModel.addAttribute("user", theUser);
        //return "user-form";
        return "registration";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") int theId) {
        userService.deleteUser(theId);
        //return "redirect:/user/list";
        return "registration";
    }
}
