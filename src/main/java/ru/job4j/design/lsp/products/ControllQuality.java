package ru.job4j.design.lsp.products;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 * Класс ControllQuality перераспределяет продукты в места хранения в зависимости
 * от оставшегося срока годности продукта.
 *
 * @author Nikolay Polegaev
 * @version 5.0 27-09-2021
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
     * Метод перераспределяет подукты заново по хранилищам.
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
     * -Создается объект класса ControllQuality c типами хранилищ.
     * -Продукты добавляются в список и передаются в метод execute() класса ControllQuality.
     * -Метод execute() распределяет продукты по хранилищам.
     * -Метод resort() перераспределяет уже перераспределенные продуктов заново по хранилищам.
     */
    public static void main(String[] args) {
        List<Store> storages = List.of(new Warehouse(), new Shop(), new Trash());
        List<Food> products = new ArrayList<>();
        Collections.addAll(products,
                new Bananas("Бананы",
                        LocalDate.of(2021, 9, 1),
                        LocalDate.of(2022, 11, 1), 50.0, 30),
                new Meat("Мясо",
                        LocalDate.of(2021, 9, 1),
                        LocalDate.of(2021, 10, 1), 600.0, 12),
                new Milk("Молоко",
                        LocalDate.of(2021, 9, 1),
                        LocalDate.of(2021, 9, 26), 120.0, 30)
        );
        ControllQuality controllQuality = new ControllQuality(storages);
        controllQuality.execute(products);
        controllQuality.resort();
        System.out.println(storages.get(0).getName());
        System.out.println(storages.get(0).getFoods());
        System.out.println(storages.get(1).getName());
        System.out.println(storages.get(1).getFoods());
        System.out.println(storages.get(2).getName());
        System.out.println(storages.get(2).getFoods());
//        for (Store store : storages) {
//            System.out.println((store.getAllAndClear()));
//        }
    }
}
