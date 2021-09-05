package ru.job4j.design.lsp.cars;

/**
 * Класс Track - это модель парковки для грузовых машин.
 *
 * @author Nikolay Polegaev
 * @version 2.0
 */
public class Track implements Place {
    /**
     * Поля:
     * -numberOfSeats - общая вместимость.
     * -numberOfCars - заполненность, сколько мест уже занято.
     */
    private final int numberOfSeats;
    private int numberOfCars;

    public Track(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    @Override
    public int getFreePlaces() {
        return numberOfSeats - numberOfCars;
    }
}
