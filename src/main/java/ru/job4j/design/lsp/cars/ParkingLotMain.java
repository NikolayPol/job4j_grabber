package ru.job4j.design.lsp.cars;

import java.util.Scanner;

public class ParkingLotMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество мест на парковке для легковых машин: ");
        int placeForPassengerCar = scanner.nextInt();
        System.out.print("Введите количество мест на парковке для грузовых машин: ");
        int placeForTrack = scanner.nextInt();
        System.out.print("Введите, сколько мест для легковых машин занимает грузовая машина: ");
        int trackToPassengerCar = scanner.nextInt();

        IParkingLot parkingLot =
                new ParkingLot(placeForPassengerCar, placeForTrack, trackToPassengerCar);

        while (true) {
            System.out.print("Введите количество занятых мест на парковке для легковых машин: ");
            parkingLot.setNumberOfPassengerCars(scanner.nextInt());
            System.out.print("Введите количество занятых мест на парковке для грузовых машин: ");
            parkingLot.setNumberOfTracks(scanner.nextInt());
            System.out.println("Количество свободных мест на парковке для легковых машин: "
                    + parkingLot.getFreePlacesForPassengerCar());
            System.out.println("Количество свободных мест на парковке для грузовых машин: "
                    + parkingLot.getFreePlacesForTrack());
        }
    }
}
