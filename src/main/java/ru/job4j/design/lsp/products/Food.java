package ru.job4j.design.lsp.products;

import java.time.LocalDate;

public class Food {
    private final String name;
    private final LocalDate createDate;
    private final LocalDate expiryDate;
    private final int discount;
    private double price;

    public Food(String name, LocalDate createDate,
                LocalDate expiryDate, double price, int discount) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discount = discount;
    }

    public void setDiscount() {
        price = price * (1 - discount * 0.01);
    }

    public void removeDiscount() {
        //System.out.println(price);
        price = Math.round(price / (1 - discount * 0.01));
        //System.out.println(price);
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", createDate=" + createDate
                + ", expiryDate=" + expiryDate
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }
}
