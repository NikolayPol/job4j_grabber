package ru.job4j.design.lsp.products;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Класс с тестами на класс ControllQuality
 *
 * @author Nikolay Polegaev
 * @version 1.0 27.09.2021
 */
public class ControllQualityTest {
    @Test
    public void whenExecute() {
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
        assertEquals(storages.get(0).getFoods().get(0), products.get(0));
        assertEquals(storages.get(1).getFoods().get(0), products.get(1));
        assertEquals(storages.get(2).getFoods().get(0), products.get(2));
    }

    @Test
    public void whenExecuteAndResort() {
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
        assertEquals(storages.get(0).getFoods().get(0), products.get(0));
        assertEquals(storages.get(1).getFoods().get(0), products.get(1));
        assertEquals(storages.get(2).getFoods().get(0), products.get(2));
    }
}