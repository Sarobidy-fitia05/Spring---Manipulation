package com.example.demo.Controlleur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControlleur {
    @GetMapping("/hello")
    public String direHeloo () {
        return "hello world ";
    }
}
