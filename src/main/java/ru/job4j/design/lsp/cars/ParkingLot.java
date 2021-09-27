package ru.job4j.design.lsp.cars;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс ParkingLot - парковка для машин.
 *
 * @author Nikolay Polegaev
 * @version 1.0 27.09.2021
 */
public class ParkingLot implements Parking {
    private final Car[] passengerCars;
    private final Car[] trucks;

    public ParkingLot(int pass, int truck) {
        passengerCars = new Car[pass];
        trucks = new Car[truck];
    }

    @Override
    public int getCars() {
        return 0;
    }

    @Override
    public void addPassengerCars(Car car) {
        for (int i = 0; i < passengerCars.length; i++) {
            if (passengerCars[i] == null) {
                passengerCars[i] = car;
            }
        }
    }

    @Override
    public void addTruck(Car car) {
        for (int i = 0; i < trucks.length; i++) {
            if (trucks[i] == null) {
                trucks[i] = car;
            }
        }
    }
}
