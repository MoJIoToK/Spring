package com.example.L2_HW;

import org.springframework.stereotype.Component;

@Component
public class Engine {

    public Engine() {
        System.out.println("Двигатель создан!");
    }

    public void go(){
        System.out.println("ПОЕХАЛИ!");
    }
}
