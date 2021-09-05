package ru.job4j.design.lsp.products;

public class ShopAction implements Strategy {
    private final Store shop;

    public ShopAction(Store shop, Food food) {
        this.shop = shop;
        add(food);
    }

    public void add(Food food) {
        shop.add(food);
    }
}
