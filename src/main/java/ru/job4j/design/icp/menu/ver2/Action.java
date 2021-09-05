package ru.job4j.design.icp.menu.ver2;

/**
 * Интерфейс Action содержит требования к классам, которые будут реализовывать
 * пункт меню.
 *
 * @author Nikolay Polegaev
 * @version 2.0
 */
public interface Action {
    /**
     * Метод act() вызывает действие при выборе пункта меню.
     */
    void act();
}
