package ru.job4j.design.lsp.products;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private String name = "Shop";
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
    public List<Food> getAllAndClear() {
        List<Food> buffer = foods;
        foods.clear();
        for (Food food : buffer) {
            float shelfLife = getShelfLife(food);
            if (0.75 < shelfLife && shelfLife < 1.0) {
                food.removeDiscount();
            }
        }
        return foods;
    }
}
