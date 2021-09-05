package ru.job4j.design.lsp.products;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Класс ControllQuality перераспределяет продукты в места хранения в зависимости
 * от оставшегося срока годности продукта.
 * @author Nikolay Polegaev
 * @version 2.0
 */
public class ControllQuality {
    /**
     * Поле foods хранит список продуктов(объекты класса Food);
     * Поля warehouse, shop, trash хранят объеты Хранилищ.
     */
    private final List<Food> foods;
    private final Store warehouse;
    private final Store shop;
    private final Store trash;

    public ControllQuality(List<Food> list, Store warehouse, Store shop, Store trash) {
        this.foods = list;
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    /**
     * Метод execute() - без параметров и ничего не возвращает.
     * Внутри метода происходит:
     *  -вызов private метода foodCheck() для перераспределения продуктов.
     */
    public void execute() {
        foodCheck();
    }

    /**
     * Меотд foodCheck() - без параметров и ничего не возвращает.
     * Внутри метода происходит:
     *  -для каждого продукта из подя foods проверка его оставшегося срока годости
     */
    private void foodCheck() {
        for (Food food : foods) {
            if (warehouse.accept(food)) {
                new WarehouseAction(warehouse, food);
                System.out.println("warehouse: " + warehouse.getAll());
            } else if (shop.accept(food)) {
                new ShopAction(shop, food);
                System.out.println("shop: " + shop.getAll());
            } else if (trash.accept(food)) {
                new TrashAction(trash, food);
                System.out.println("trash: " + trash.getAll());
            }
        }
    }

    /**
     * Метод resort() - без параметров и ничего не возвращает.
     * Внутри метода происходит:
     *  -очистка поля foods класса ControllQuality;
     *  -очистка полей foods классов Warehouse, Shop, Trash c добавлением продуктов в
     *   поле foods класса ControllQuality; Если у продукта установлена скидка(discount),
     *   то цена возвращается в значение без нее.
     *  -Далее вызывается метод execute() для перераспределения продуктов
     *   по классам Warehouse, Shop, Trash.
     */
    public void resort() {
        foods.clear();
        foods.addAll(warehouse.getAll());
        warehouse.getAll().clear();
        for (Food food : shop.getAll()) {
            float shelfLife = shop.getShelfLife(food);
            if (0.75 < shelfLife && shelfLife < 1.0) {
                food.removeDiscount();
            }
            foods.add(food);
        }
        shop.getAll().clear();
        foods.addAll(trash.getAll());
        trash.getAll().clear();
        execute();
    }

    /**
     * В методе main() происходит ручное тестирование.
     * Внутри метода происходит:
     *  -Создание объектов продуктов со сроком изготовления, сроком годности, ценой и
     *   размером возможной скидки.
     *  -Продукты добавляются в список и передаются в конструктор
     *   класса ControllQuality. Создается объект класса ControllQuality c типами хранилищ.
     *  -У объекта класса ControllQuality вызываются методы execute()
     *   для распределения продуктов по хранилищам и метод resort() для перераспределения
     *   уже перераспределенных продуктов заново по хранилищам.
     */
    public static void main(String[] args) {
        List<Food> list = new ArrayList<>();
        Collections.addAll(list,
                new Bananas("Бананы",
                        LocalDate.of(2021, 7, 1),
                        LocalDate.of(2022, 5, 1), 50.0, 30),
                new Meat("Мясо",
                        LocalDate.of(2021, 7, 1),
                        LocalDate.of(2021, 9, 1), 600.0, 12),
                new Milk("Молоко",
                        LocalDate.of(2021, 7, 1),
                        LocalDate.of(2021, 9, 20), 120.0, 30)
        );
        ControllQuality controllQuality = new ControllQuality(list,
                new Warehouse(), new Shop(), new Trash());
        controllQuality.execute();
        controllQuality.resort();
    }
}
