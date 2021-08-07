package ru.job4j.design.lsp.products;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public List<Food> getAll() {
        return foods;
    }
}
