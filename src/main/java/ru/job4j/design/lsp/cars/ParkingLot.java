package ru.job4j.design.lsp.cars;

/**
 * Класс ParkingLot - это модель всей парковки.
 * Модель состоит из 2 объектов:
 * -PassengerCar - парковка для легковых
 * -Track - парковка для грузовых).
 *
 * @author Nikolay Polegaev
 * @version 2.0
 */
public class ParkingLot implements Lot {
    /**
     * Поля:
     * -passengerCarLot     - объект-парковка для легковых машин.
     * -trackLot            - объект-парковка для грузовых машин.
     * -trackToPassengerCar - число, показывающее сколько мест для легковых занимает гузовая
     *                        машина.
     */
    private final Place passengerCarLot;
    private final Place trackLot;
    private final int trackToPassengerCar;

    public ParkingLot(int seatsOfPassenger, int seatsOfTrack, int trackToPassengerCar) {
        this.passengerCarLot = new PassengerCar(seatsOfPassenger);
        this.trackLot = new Track(seatsOfTrack);
        this.trackToPassengerCar = trackToPassengerCar;
    }

    @Override
    public void setNumberOfPassengerCars(int numberOfPassengerCars) {
        passengerCarLot.setNumberOfCars(numberOfPassengerCars);
    }

    @Override
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
