package ru.job4j.design.icp.menu.ver2;

/**
 * Класс PrintAction содержит конкретное действие, которое будет происходить при выборе пункта меню.
 *
 * @author Nikolay Polegaev
 * @version 2.0
 */
public class PrintAction implements Action {

    @Override
    public void act() {
        System.out.println("Выполнено действие PrintAction");
    }
}