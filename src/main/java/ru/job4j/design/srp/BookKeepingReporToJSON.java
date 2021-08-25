package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.function.Predicate;

public class BookKeepingReporToJSON extends BookKeepingReport {

    public BookKeepingReporToJSON(Store store) {
        super(store);
    }

    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        for (Employee employee : getStore().findBy(filter)) {
            employee.setSalary(0.87 * employee.getSalary());
            Gson gson = new GsonBuilder().create();
            text.append(gson.toJson(employee)).append(System.lineSeparator());
        }
        return text.toString();
    }
}
