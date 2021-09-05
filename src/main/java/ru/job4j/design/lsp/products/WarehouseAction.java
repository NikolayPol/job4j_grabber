package ru.job4j.design.lsp.products;

public class WarehouseAction implements Strategy {
    private final Store warehouse;

    public WarehouseAction(Store warehouse, Food food) {
        this.warehouse = warehouse;
        add(food);
    }

    public void add(Food food) {
        warehouse.add(food);
    }
}
