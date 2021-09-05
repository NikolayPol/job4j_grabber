package ru.job4j.design.lsp.products;

public class TrashAction implements Strategy {
    private final Store trash;

    public TrashAction(Store trash, Food food) {
        this.trash = trash;
        add(food);
    }

    public void add(Food food) {
        trash.add(food);
    }
}
