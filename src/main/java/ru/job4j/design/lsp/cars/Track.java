package ru.job4j.design.lsp.cars;

public class Track implements Place {
    private int numberOfSeats;
    private int numberOfCars;

    public Track(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    @Override
    public int getFreePlaces() {
        return numberOfSeats - numberOfCars;
    }
}
