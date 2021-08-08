package ru.job4j.design.lsp.products;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ControllQuality {
    private final List<Food> foods;
    private final Warehouse warehouse = new Warehouse();
    private final Shop shop = new Shop();
    private final Trash trash = new Trash();

    public ControllQuality(List<Food> list) {
        this.foods = list;
    }

    public void execute() {
        foodCheck();
    }

    private void foodCheck() {
        for (Food food : foods) {
            float shelfLife = getShelfLife(food);
            //System.out.println(shelfLife);
            if (shelfLife < 0.25) {
                new WarehouseAction(warehouse, food);
                //System.out.println("warehouse: " + warehouse.getAll());
            } else if (0.25 <= shelfLife && shelfLife <= 0.75) {
                new ShopAction(shop, food);
                //System.out.println("shop: " + shop.getAll());
            } else if (0.75 < shelfLife && shelfLife < 1.0) {
                food.setDiscount();
                new ShopAction(shop, food);
                //System.out.println("shop: " + shop.getAll());
            } else if (shelfLife >= 1.0) {
                new TrashAction(trash, food);
                //System.out.println("trash: " + trash.getAll());
            }
        }
    }

    private float getShelfLife(Food food) {
        LocalDate create = food.getCreateDate();
        LocalDate expiry = food.getExpiryDate();
        LocalDate now = LocalDate.now();

        Date dateCreate = Date.from(create.atStartOfDay()
                .atZone(ZoneId.systemDefault()).toInstant());
        Date dateExpiry = Date.from(expiry.atStartOfDay()
                .atZone(ZoneId.systemDefault()).toInstant());
        Date dateNow = Date.from(now.atStartOfDay()
                .atZone(ZoneId.systemDefault()).toInstant());

        return ((float) (dateNow.getTime() - dateCreate.getTime())
                / (dateExpiry.getTime() - dateCreate.getTime()));
    }

    public void resort() {
        foods.clear();
        foods.addAll(warehouse.getAll());
        warehouse.getAll().clear();

        for (Food food : shop.getAll()) {
            float shelfLife = getShelfLife(food);
            if (0.75 < shelfLife && shelfLife < 1.0) {
                food.removeDiscount();
            }
            foods.add(food);
        }
        shop.getAll().clear();

        foods.addAll(trash.getAll());
        trash.getAll().clear();
        //System.out.println(foods);

        execute();
    }

    public static void main(String[] args) {
        List<Food> list = new ArrayList<>();
        Collections.addAll(list,
                new Bananas("Бананы",
                        LocalDate.of(2021, 6, 1),
                        LocalDate.of(2022, 4, 1), 50.0, 30),
                new Meat("Мясо",
                        LocalDate.of(2021, 6, 1),
                        LocalDate.of(2021, 8, 1), 600.0, 12),
                new Milk("Молоко",
                        LocalDate.of(2021, 6, 1),
                        LocalDate.of(2021, 8, 20), 120.0, 30)
        );
        //System.out.println(list);
        ControllQuality controllQuality = new ControllQuality(list);
        controllQuality.execute();
        controllQuality.resort();
    }
}
