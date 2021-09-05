package ru.job4j.design.lsp.products;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private final List<Food> foods = new ArrayList<>();

    public Shop() {
    }

    @Override
    public boolean accept(Food food) {
        if (0.25 <= getShelfLife(food) && getShelfLife(food) <= 0.75) {
            return true;
        } else if (0.75 < getShelfLife(food) && getShelfLife(food) < 1.0) {
            food.setDiscount();
            return true;
        }
        return false;
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
