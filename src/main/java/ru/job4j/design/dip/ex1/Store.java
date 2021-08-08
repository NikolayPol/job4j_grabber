package ru.job4j.design.dip.ex1;

import java.util.List;

public class Store {
    private List<String> list;

    public Store(Shop shop) {
        this.list = shop.getList();
    }
}
