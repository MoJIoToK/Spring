package com.example.L2_HW;

public class Car {
    Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
        engine.go();
    }
}
