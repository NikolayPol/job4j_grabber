package ru.job4j.design.icp.menu.ver1;

import java.util.List;

public interface Item {
    String getName();

    List<Item> getList();

    default void show(List<Item> list) {
        for (Item item : list) {
            item.show();
        }
    }

    void show();

    default void iterateList(List<Item> list, String num) {
        for (Item item : list) {
            if (item.getName().contains(num)) {
                item.execute();
            } else {
                item.iterateList(num);
            }
        }
    }

    void iterateList(String num);

    void execute();

    void add(Item item);
}
