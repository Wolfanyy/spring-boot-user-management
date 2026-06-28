package com.github.wolfanyy.springbootusermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/users")
    public String usersPage() {
        return "forward:/users/index.html";
    }
}