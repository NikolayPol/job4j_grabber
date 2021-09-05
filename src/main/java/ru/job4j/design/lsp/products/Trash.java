package ru.job4j.design.lsp.products;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private List<Food> foods = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        return getShelfLife(food) > 1.0;
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
