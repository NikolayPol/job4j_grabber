package ru.job4j.design.srp;

import java.util.*;
import java.util.function.Predicate;

public class HrReport extends ReportEngine {

    public HrReport(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;").append(System.lineSeparator());
        Map<Double, String> map = new TreeMap<Double, String>(Collections.reverseOrder());
        for (Employee employee : getStore().findBy(filter)) {
            map.put(employee.getSalary(), employee.getName());
        }
        for (Double key : map.keySet()) {
            text.append(map.get(key)).append("; ")
                    .append(key).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

//    public static void main(String[] args) {
//        MemStore store = new MemStore();
//        Calendar now = Calendar.getInstance();
//        Employee worker1 = new Employee("Ivan", now, now, 100);
//        Employee worker2 = new Employee("Petr", now, now, 300);
//        Employee worker3 = new Employee("Boris", now, now, 200);
//        store.add(worker1);
//        store.add(worker2);
//        store.add(worker3);
//        Report engine = new HrReport(store);
//        System.out.println(engine.generate(em -> true));
//    }
}
