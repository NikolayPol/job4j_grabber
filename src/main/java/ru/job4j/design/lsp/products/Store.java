package ru.job4j.design.lsp.products;

import java.util.List;

public interface Store {
    void add(Food food);

    List<Food> getAll();
}
