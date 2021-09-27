package ru.job4j.design.lsp.cars;

/**
 * Класс Truck - грузовая машина.
 *
 * @author Nikolay Polegaev
 * @version 1.0 27.09.2021
 */
public class Truck implements Car {
    private int places;

    public Truck(int places) {
        this.places = places;
    }
}
