package com.security.controller;

import com.security.dto.UserRequest;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    // add user
    @PostMapping("/addUser")
    public String addUser(@RequestBody UserRequest request) {
        return userService.saveUser(request);
    }

    // public api
    @GetMapping("/public")
    public String publicAPI() {
        return "This is public api";
    }

    // user api
    @GetMapping("/user")
    public String userAPI() {
        return "This is user API";
    }

    // admin api
    @GetMapping("/admin")
    public String adminAPI() {
        return "This is admin API";
    }
}
