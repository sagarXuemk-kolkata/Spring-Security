package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    // add user

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
