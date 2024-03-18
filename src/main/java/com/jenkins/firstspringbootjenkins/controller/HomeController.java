package com.jenkins.firstspringbootjenkins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/admin")
    public String admin() {
        return "Welcome to admin page";
    }

    @GetMapping("/user")
    public String user() {
        return "Welcome to user page";
    }

}