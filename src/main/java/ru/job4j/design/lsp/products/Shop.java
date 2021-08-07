package ru.job4j.design.lsp.products;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private final List<Food> foods = new ArrayList<>();

    public Shop() {
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
