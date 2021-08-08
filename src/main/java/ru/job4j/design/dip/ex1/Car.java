package ru.job4j.design.dip.ex1;

public class Car {
    private Engine engine;
    private Wheel wheels;

    public Car(Engine engine, Wheel wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }
}
