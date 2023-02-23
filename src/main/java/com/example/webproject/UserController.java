package com.example.webproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/createuser")
    public void createUser(@RequestBody Users user){
        userService.createUser(user);
    }
    @GetMapping("/")
    public String menu(){
        return "Hello";
    }
    @GetMapping("/showallusers")
    public List<Users> showAllUsers(){
        return userService.getAllUser();
    }
}
