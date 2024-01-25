package com.example.s4_hw.controllers;

import com.example.s4_hw.services.HelloService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class HelloController {


    private final HelloService helloService;

    @RequestMapping("/hello")
    public String hello(){
        return "add_hello.html";
    }
    @PostMapping("/add_hello.html")
    public String addHello(Model model){
        helloService.increaseCount();
        var count = helloService.getCountHello();
        model.addAttribute("count", count);
        return "count";
    }

    @GetMapping("/add_hello.html")
    public String getHello(Model model){
        var count = helloService.getCountHello();
        model.addAttribute("count", count);
        return "count";
    }

}
