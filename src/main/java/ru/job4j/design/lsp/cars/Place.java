package ru.job4j.design.lsp.cars;

/**
 * Интерфейс Place содержит требование к парковке.
 *
 * @author Nikolay Polegaev
 * @version 2.0
 */
public interface Place {
    /**
     * Метод setNumberOfCars(int numberOfCars) устанавливает общую вместимость машин.
     * @param numberOfCars - количество машин.
     */
    void setNumberOfCars(int numberOfCars);

    /**
     * Метод getFreePlaces() возвращает количство свободных мест.
     * @return - возвращает количство свободных мест.
     */
    int getFreePlaces();
}
