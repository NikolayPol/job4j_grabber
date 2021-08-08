package ru.job4j.design.icp.ex1;

public class Car implements Machine {
    @Override
    public void move() {

    }

    @Override
    public void dig() {
        throw new UnsupportedOperationException();
    }
}
