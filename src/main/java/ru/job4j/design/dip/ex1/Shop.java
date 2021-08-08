package ru.job4j.design.dip.ex1;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<String> list = new ArrayList<>();

    public Shop() {
    }

    public List<String> getList() {
        return list;
    }
}
