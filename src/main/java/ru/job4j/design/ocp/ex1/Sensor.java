package ru.job4j.design.ocp.ex1;

public class Sensor extends Device {
    @Override
    void doFunction() {
        System.out.println("Вывести предупреждение при T > 40C");
    }
}
