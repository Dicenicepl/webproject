package com.example.webproject.controller;

import com.example.webproject.service.UserService;
import com.example.webproject.user.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {
    private UserService userService;
    public AuthController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/index")
    public String home(){
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        Users user = new Users();
        model.addAttribute("user",user);
        return "register";
    }
    @PostMapping("/register/save")
    public String registration(Users user, BindingResult result, Model model){

        if (result.hasErrors()){
            model.addAttribute("user",user);
            return "/register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }
    @GetMapping("/users")
    public String users(Model model){
        List<Users> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
