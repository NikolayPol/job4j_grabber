package ru.job4j.design.lsp.cars;

/**
 * Интерфейс Lot содержит требование к объектам, содержащим парковочные места.
 *
 * @author Nikolay Polegaev
 * @version 2.0
 */
public interface Lot {
    /**
     * Метод setNumberOfPassengerCars(int numberOfPassengerCars) устанавливает общее количество
     * (ёмкость) мест для легковых машин.
     * @param numberOfPassengerCars - общее количество легковых машин, т.е. ёмкость, вместимость.
     */
    void setNumberOfPassengerCars(int numberOfPassengerCars);

    /**
     * Метод setNumberOfTracks(int numberOfTracks) устанавливает общее количество
     * (ёмкость) мест для грузовых машин.
     * @param numberOfTracks - общее количество грузовых машин, т.е. ёмкость, вместимость.
     */
    void setNumberOfTracks(int numberOfTracks);

    /**
     * Метод getFreePlacesForPassengerCar() возвращает число свободных мест для легковых машин.
     */
    int getFreePlacesForPassengerCar();

    /**
     * Метод getFreePlacesForTrack() возвращает число свободных мест для грузовых машин.
     */
    int getFreePlacesForTrack();
}
