package ru.job4j.design.lsp.products;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Milk extends Food {
    public Milk(String name, LocalDate createDate,
                LocalDate expiryDate, double price, int discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}
