package ru.job4j.design.srp;

import javax.xml.bind.JAXBException;
import java.util.function.Predicate;

public class ReportEngine implements Report {

    private final Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired().getTime()).append(";")
                    .append(employee.getFired().getTime()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

}