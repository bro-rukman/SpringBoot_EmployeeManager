package com.example.crud_api.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class WelcomeController {
    @GetMapping("/")
    public String welcome(){
        return "Welcome to Spring boot API";
    }
    @GetMapping("/user")
    public String user(){
        return "Welcome user";
    }
    @GetMapping("/admin")
    public String admin(){
        return "Welcome admin";
    }
}
