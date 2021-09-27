package ru.job4j.design.lsp.cars;

/**
 * Интерфейс Parking - описывает парковку.
 *
 * @author Nikolay Polegaev
 * @version 1.0 27.09.2021
 */
public interface Parking {

    int getCars();

    void addPassengerCars(Car car);

    void addTruck(Car car);
}
