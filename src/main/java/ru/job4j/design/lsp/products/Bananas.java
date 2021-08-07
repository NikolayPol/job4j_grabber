package ru.job4j.design.lsp.products;

import java.time.LocalDate;

public class Bananas extends Food {
    public Bananas(String name, LocalDate createDate,
                   LocalDate expiryDate, double price, int discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}
