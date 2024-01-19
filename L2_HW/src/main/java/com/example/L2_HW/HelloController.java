package com.example.L2_HW;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public static String hello() {
        return "Hello, Spring Boot!";
    }
}
