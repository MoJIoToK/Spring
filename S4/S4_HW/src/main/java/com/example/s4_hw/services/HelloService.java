package com.example.s4_hw.services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private int countHello = 0;

    public void increaseCount(){
        countHello++;
    }

    public int getCountHello(){
        return countHello;
    }

}
