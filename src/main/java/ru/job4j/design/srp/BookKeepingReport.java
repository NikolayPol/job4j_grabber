package ru.job4j.design.srp;

import java.util.Calendar;
import java.util.function.Predicate;

public class BookKeepingReport extends ReportEngine {

    public BookKeepingReport(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return getEmployess(filter);
    }

    private String getEmployess(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;").append(System.lineSeparator());
        for (Employee employee : getStore().findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired().getTime()).append(";")
                    .append(employee.getFired().getTime()).append(";")
                    .append(0.87 * employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public static void main(String[] args) {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Petr", now, now, 300);
        Employee worker3 = new Employee("Boris", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new BookKeepingReport(store);
        //Report engine = new BookKeepingReporToXML(store);
        //Report engine = new BookKeepingReporToJSON(store);
        //Report engine = new BookKeepingReporToHTML(store);
        System.out.println(engine.generate(em -> true));
    }
}
