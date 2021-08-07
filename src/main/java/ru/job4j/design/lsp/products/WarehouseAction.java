package ru.job4j.design.lsp.products;

public class WarehouseAction implements Strategy {
    private final Warehouse warehouse;

    public WarehouseAction(Warehouse warehouse, Food food) {
        this.warehouse = warehouse;
        add(food);
    }

    public void add(Food food) {
        warehouse.add(food);
    }
}
