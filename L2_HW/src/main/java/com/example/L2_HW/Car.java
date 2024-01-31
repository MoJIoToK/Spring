package com.example.L2_HW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Car {
    @Autowired // 3 - вариант
    Engine engine;

    //1- вариант, самый правильный
//    public Car(Engine engine) {
//        this.engine = engine;
//        engine.go();
//    }

    //2- вариант
//    public Car() {
//    }
//
//    public void setEngine(Engine engine) {
//        this.engine = engine;
//        engine.go();
//    }

    public void start(){
        engine.go();
    }



}
