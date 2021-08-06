package ru.job4j.design.lsp.cars;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PassengerCarTest {

    @Test
    public void setAndGetNumberOfCars() {
        Place passengerCar = new PassengerCar(16);
        passengerCar.setNumberOfCars(2);
        assertThat(passengerCar.getFreePlaces(), is(14));
    }
}