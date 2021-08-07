package ru.job4j.design.lsp.ex1;

public class Car extends Machine {
    private int maxSpeed;

    @Override
    public void doSomthing() {
        super.doSomthing();
        // maxSpeed в логике
    }
}
