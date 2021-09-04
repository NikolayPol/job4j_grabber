package ru.job4j.design.icp.menu.ver2;

import java.util.List;

public interface Action {
    void act();

    default void iterateList(String parentName, List<Item> list, Item child) {
        for (Item item : list) {
            if (item.getName().contains(parentName)) {
                item.add(child);
            } else {
                iterateList(parentName, item.getItems(), child);
            }
        }
    }

    default String iterateName(List<Item> list) {
        StringBuilder sb = new StringBuilder();
        for (Item item : list) {
            sb.append(item.getName()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
