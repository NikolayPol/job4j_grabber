package ru.job4j.design.lsp.cars;

public class ParkingLot implements IParkingLot {
    private final Place passengerCarLot;
    private final Place trackLot;
    private final int trackToPassengerCar; //сколько мест для легковых занимает грузовая машина

    public ParkingLot(int seatsOfPassenger, int seasOfTrack, int trackToPassengerCar) {
        this.passengerCarLot = new PassengerCar(seatsOfPassenger);
        this.trackLot = new Track(seasOfTrack);
        this.trackToPassengerCar = trackToPassengerCar;
    }

    public void setNumberOfPassengerCars(int numberOfPassengerCars) {
        passengerCarLot.setNumberOfCars(numberOfPassengerCars);
    }

    public void setNumberOfTracks(int numberOfTracks) {
        trackLot.setNumberOfCars(numberOfTracks);
    }

    @Override
    public int getFreePlacesForPassengerCar() {
        return passengerCarLot.getFreePlaces();
    }

    @Override
    public int getFreePlacesForTrack() {
        return trackLot.getFreePlaces() + passengerCarLot.getFreePlaces() / trackToPassengerCar;
    }

}