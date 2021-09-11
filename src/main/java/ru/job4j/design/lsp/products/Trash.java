package ru.job4j.design.lsp.products;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private final String name = "Trash";
    private final List<Food> foods = new ArrayList<>();

    public String getName() {
        return name;
    }

    @Override
    public List<Food> getFoods() {
        return foods;
    }

    @Override
    public boolean accept(Food food) {
        return getShelfLife(food) > 1.0;
    }

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public List<Food> getAllAndClear() {
        List<Food> buffer = foods;
        foods.clear();
        return buffer;
    }
}
