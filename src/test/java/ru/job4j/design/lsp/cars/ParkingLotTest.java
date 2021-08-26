package ru.job4j.design.lsp.cars;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParkingLotTest {

    @Test
    public void setAndGetNumberOfPassengerCars() {
        Lot parkingLot = new ParkingLot(16, 8, 4);
        parkingLot.setNumberOfPassengerCars(2);
        assertThat(parkingLot.getFreePlacesForPassengerCar(), is(14));
    }

    @Test
    public void seAndGettNumberOfTracks() {
        Lot parkingLot = new ParkingLot(16, 8, 4);
        parkingLot.setNumberOfTracks(2);
        assertThat(parkingLot.getFreePlacesForTrack(), is(10));
    }

}