package ru.job4j.design.icp.menu.ver2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс Item описывает модель пункта меню.
 *
 * @author Nikolay Polegaev
 * @version 2.0
 */
public class Item implements Action {
    /**
     * Поля:
     * -name содержит имя пункта меню.
     * -action содержит конкретное дейсвие,
     *  которое будет выполнено при выборе этого пункта меню.
     * -items содержит список дочерних пунктов меню.
     */
    private final String name;
    private final Action action;
    private final List<Item> items = new ArrayList<>();

    public Item(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    /**
     * Метод add() добавляет дочерний пункт меню.
     * @param item-объект класса Item.
     */
    public void add(Item item) {
        items.add(item);
    }

    /**
     * Метод act() выполняет действие, если выбран этот пункт меню.
     */
    @Override
    public void act() {
        action.act();
    }

    @Override
    public String toString() {
        return "Item{"
                + "name='" + name + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
