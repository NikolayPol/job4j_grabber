package ru.job4j.design.icp.menu.ver2;

import java.util.ArrayList;
import java.util.List;

public class Item implements Action {
    private String name;
    private List<Item> items  = new ArrayList<>();

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void act() { //действия при выборе данного пункта
        System.out.println("Action: " + name);
    }
}
