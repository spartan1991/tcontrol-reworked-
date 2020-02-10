package com.vcprojects.tcontrol.controllers;

import java.util.List;

import com.vcprojects.tcontrol.service.SecurityService;
import com.vcprojects.tcontrol.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @Autowired                                     //11.02.2020
    private SecurityService securityService;       //11.02.2020

    @Autowired                                     //11.02.2020
    private UserValidator userValidator;           //11.02.2020

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
    public String saveUser(@ModelAttribute("user") User theUser,
                           BindingResult bindingResult, Model model) {   //11.02.2020
        userValidator.validate(theUser, bindingResult);                  //11.02.2020
        if(bindingResult.hasErrors()){
            return "registration";
        } //11.02.2020

        userService.saveUser(theUser);

        securityService.autoLogin(theUser.getUsername(), theUser.getConfirmPassword());

        return "redirect:/";
    }

    @GetMapping("/authentication")
    public String showAuthenticationForm(Model theModel,
                                         String error, String logout) {  //11.02.2020
        if(error != null){
            theModel.addAttribute("error", "Username or password is incorrect");
        }  //11.02.2020
        if(logout != null){
            theModel.addAttribute("message", "Logged out successfully.");
        }  //11.02.2020

//        User theUser = new User();                         //Commented 11.02.2020
//        theModel.addAttribute("user", theUser);            //Commented 11.02.2020

        return "authentication";
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
