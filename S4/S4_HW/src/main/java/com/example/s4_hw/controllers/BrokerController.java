package com.example.s4_hw.controllers;

import com.example.s4_hw.model.BrokerAccount;
import com.example.s4_hw.services.BrokerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class BrokerController {

    private final BrokerService brokerService;

    @GetMapping("/portfolio")
    public String getPortfolio(Model model){
        model.addAttribute("portfolio", brokerService.getPortfolio());
        return "portfolio";
    }

    @PostMapping("/portfolio")
    public String addTicker(BrokerAccount br, Model model){
        brokerService.addTicker(br);
        model.addAttribute("portfolio", brokerService.getPortfolio());
        return "portfolio";
    }

}
