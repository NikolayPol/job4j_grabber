package ru.job4j.design.lsp.products;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public interface Store {
    boolean accept(Food food);

    void add(Food food);

    String getName();

    List<Food> getFoods();

    List<Food> getAllAndClear();

    /**
     * Метод getShelfLife() вычисляет соотношение пройденного срока
     * к сроку годности продукта.
     * @param food продукт-объект класса Food.
     * @return float число-результат.
     */
    default float getShelfLife(Food food) {
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
}
