package ru.job4j.design.lsp.products;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {

    private List<Food> foods = new ArrayList<>();

    public Warehouse() {
    }

    @Override
    public boolean accept(Food food) {
        return getShelfLife(food) < 0.25;
    }

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public List<Food> getAll() {
        return foods;
    }
}
