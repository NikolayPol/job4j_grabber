package ru.job4j.design.lsp.cars;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Класс ParkingLotTest тестирует класс ParkingLot.
 *
 * @author Nikolay Polegaev
 * @version 1.0 27.09.2021
 */
public class ParkingLotTest {
    @Test
    public void whenCarsPlaced() {
        //созадали объект парковка с 1 легковым и 1 грузовым местом
        Parking parking = new ParkingLot(1, 1);
        //создали объект пассажирской машины
        Car passengerCar = new PassengerCar();
        //создали объект грузовой машины
        Car truck = new Truck(2);
        //поставили 2 эти машины на парковку
        parking.addPassengerCars(passengerCar);
        parking.addTruck(truck);
        //проверяем, что машины встали
        assertEquals(parking.getCars(), 2);
    }

    @Test
    public void whenCarsNotPlaced() {
        //созадали объект парковка с 1 легковым и 1 грузовым местом
        Parking parking = new ParkingLot(1, 1);
        //создали объект пассажирской машины
        PassengerCar passengerCar = new PassengerCar();
        //создали объект грузовой машины
        Truck truck = new Truck(2);
        //поставили 3 машины на парковку. Одна не поместилась
        parking.addPassengerCars(passengerCar);
        parking.addPassengerCars(passengerCar);
        parking.addTruck(truck);
        //проверяем, что одна машина не поместилась
        assertEquals(parking.getCars(), 2);
    }

    @Test
    public void when2PassengerNotPlaced() {
        Parking parking = new ParkingLot(1, 0);
        PassengerCar passengerCar = new PassengerCar();
        parking.addPassengerCars(passengerCar);
        parking.addPassengerCars(passengerCar);
        assertEquals(parking.getCars(), 1);
    }

    @Test
    public void when1TruckPlaced() {
        //парковка: 2 места для легковых и 0 для грузовых
        Parking parking = new ParkingLot(2, 0);
        //конструктор класса Truck принимает число занимаемых мест для легковой машины
        Truck truck = new Truck(2);
        parking.addTruck(truck);
        //1 грузовая заняла 2 места для легковой
        assertEquals(parking.getCars(), 1);
    }

    @Test
    public void when1TruckNotPlaced() {
        //парковка: 1 место для легковых и 0 для грузовых
        Parking parking = new ParkingLot(1, 0);
        //конструктор класса Truck принимает число занимаемых мест для легковой машины
        Truck truck = new Truck(2);
        parking.addTruck(truck);
        //1 грузовая занимает 2 места для легковой. Грузовик не паркуется.
        assertEquals(parking.getCars(), 0);
    }
}
