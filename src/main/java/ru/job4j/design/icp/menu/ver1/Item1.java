package ru.job4j.design.icp.menu.ver1;

import java.util.ArrayList;
import java.util.List;

public class Item1 implements Item {
    private List<Item> list = new ArrayList<>();
    private String name;

    public Item1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Item> getList() {
        return list;
    }

    @Override
    public void show() {
        System.out.println(name);
        show(list);
    }

    @Override
    public void iterateList(String num) {
        for (Item item : list) {
            if (item.getName().replace("-", "").equals(num)) {
                item.execute();
            } else {
                item.iterateList(num);
            }
        }
    }

    @Override
    public void execute() {
        System.out.println("execute " + name);
    }

    @Override
    public void add(Item item) {
        list.add(item);
    }
}
