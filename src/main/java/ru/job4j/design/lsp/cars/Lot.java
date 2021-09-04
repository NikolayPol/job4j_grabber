package ru.job4j.design.lsp.cars;

public interface Lot {
    void setNumberOfPassengerCars(int numberOfPassengerCars);

    void setNumberOfTracks(int numberOfTracks);

    int getFreePlacesForPassengerCar();

    int getFreePlacesForTrack();
}
