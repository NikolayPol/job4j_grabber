package ru.job4j.design.lsp.products;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {

    private List<Food> foods = new ArrayList<>();

    public Warehouse() {
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
