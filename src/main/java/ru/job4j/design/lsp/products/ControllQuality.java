package ru.job4j.design.lsp.products;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 * Класс ControllQuality перераспределяет продукты в места хранения в зависимости
 * от оставшегося срока годности продукта.
 *
 * @author Nikolay Polegaev
 * @version 4.0 13-09-2021
 */
public class ControllQuality {
    /**
     * Поле storages хранит список хранилищ;
     */
    private final List<Store> storages;

    public ControllQuality(List<Store> storages) {
        this.storages = storages;
    }

    /**
     * Метод execute() - принимает список продуктов и перераспределяет их по хранилищам.
     * Внутри метода происходит:
     * -вызов private метода foodCheck() для перераспределения продуктов.
     */
    public void execute(List<Food> products) {
        for (Food food : products) {
            for (Store store : storages) {
                if (store.accept(food)) {
                    store.add(food);
                    System.out.println(store.getName() + ": " + store.getFoods()
                            + " Срок годности: " + store.getShelfLife(food));
                }
            }
        }
    }

    /**
     * Метод resort() - без параметров и ничего не возвращает.
     * Внутри метода происходит:
     * -очистка поля foods класса ControllQuality;
     * -очистка полей foods классов Warehouse, Shop, Trash c добавлением продуктов в
     * поле foods класса ControllQuality; Если у продукта установлена скидка(discount),
     * то цена возвращается в значение без нее.
     * -Далее вызывается метод foodCheck() для перераспределения продуктов
     * по классам Warehouse, Shop, Trash.
     */
    public void resort() {
        for (Store store : storages) {
            execute(store.getAllAndClear());
        }
    }

    /**
     * В методе main() происходит ручное тестирование.
     * Внутри метода происходит:
     * -Создание объектов продуктов со сроком изготовления, сроком годности, ценой и
     * размером возможной скидки.
     * -Продукты добавляются в список и передаются в конструктор
     * класса ControllQuality. Создается объект класса ControllQuality c типами хранилищ.
     * -У объекта класса ControllQuality вызываются методы execute()
     * для распределения продуктов по хранилищам и метод resort() для перераспределения
     * уже перераспределенных продуктов заново по хранилищам.
     */
    public static void main(String[] args) {
        List<Store> storages = List.of(new Warehouse(), new Shop(), new Trash());
        List<Food> products = new ArrayList<>();
        Collections.addAll(products,
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
        ControllQuality controllQuality = new ControllQuality(storages);
        controllQuality.execute(products);
        controllQuality.resort();
    }
}
