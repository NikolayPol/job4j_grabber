package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

public class HrReportToJSON extends HrReport {

    public HrReportToJSON(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        Map<Double, String> map = new TreeMap<>(Collections.reverseOrder());
        for (Employee employee : getStore().findBy(filter)) {
            map.put(employee.getSalary(), employee.getName());
        }
        for (Double key : map.keySet()) {
            Gson gson = new GsonBuilder().create();
            Employee emp = new Employee(map.get(key), key);
            text.append(gson.toJson(emp)).append(System.lineSeparator());
        }
        return text.toString();
    }
}

