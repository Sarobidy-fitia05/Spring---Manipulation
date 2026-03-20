package com.example.demo.Controlleur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeControlleur {
    @GetMapping("/welcome")
    public String welcome(@RequestParam(name = "name") String name) {
        return "Welcome " + name ;
    }
}
