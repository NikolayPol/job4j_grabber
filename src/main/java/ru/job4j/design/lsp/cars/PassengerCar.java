package ru.job4j.design.lsp.cars;

public class PassengerCar implements Place {
    private final int numberOfSeats;
    private int numberOfCars;

    public PassengerCar(int numberOfSeats) {
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
