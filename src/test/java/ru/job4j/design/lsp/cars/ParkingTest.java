package ru.job4j.design.lsp.cars;

import org.junit.Test;
import static org.junit.Assert.*;

public class ParkingTest {
    @Test
    public void whenCarsPlaced() {
        //созадали объект парковка с 1 легковым и 1 грузовым местом
        Parking parking = new Parking(1, 1);
        //создали объект пассажирской машины
        PassengerCar passengerCar = new PassengerCar();
        //создали объект грузовой машины
        Truck truck = new Truck();
        //поставили 2 эти машины на парковку
        parking.addCar(passengerCar);
        parking.addCar(Truck);
        //проверяем, что машины встали
        assertEquals(parking.getCars, 2);
    }

    @Test
    public void whenCarsNotPlaced() {
        //созадали объект парковка с 1 легковым и 1 грузовым местом
        Parking parking = new Parking(1, 1);
        //создали объект пассажирской машины
        PassengerCar passengerCar = new PassengerCar();
        //создали объект грузовой машины
        Truck truck = new Truck();
        //поставили 3 машины на парковку. Одна не поместилась
        parking.addPassengerCars(passengerCar);
        parking.addPassengerCars(passengerCar);
        parking.addTrucks(truck);
        //проверяем, что одна машина не поместилась
        assertEquals(parking.getCars, 2);
    }

    @Test
    public void when2PassengerNotPlaced() {
        Parking parking = new Parking(1, 0);
        PassengerCar passengerCar = new PassengerCar();
        parking.addPassengerCars(passengerCar);
        parking.addPassengerCars(passengerCar);
        assertEquals(parking.getCars, 1);
    }

    @Test
    public void when2TruckPlaced() {
        Parking parking = new Parking(2, 1);
        PassengerCar passengerCar = new PassengerCar();
        Truck truck = new Truck();
        parking.addTrucks(truck);
        parking.addTrucks(truck);
        //1 грузовая заняла 2 места для легковой
        assertEquals(parking.getCars, 2);
    }
}
