package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.Calendar;

public class ItReportTest {
    @Test
    public void whenItGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ItReport(store);
        StringBuilder expect = new StringBuilder().append("<!DOCTYPE html>")
                .append(System.lineSeparator())
                .append("<html lang=\"en\"")
                .append(System.lineSeparator())
                .append("      xmlns=\"http://www.w3.org/1999/xhtml\">")
                .append(System.lineSeparator()).append("<head>")
                .append(System.lineSeparator()).append("</head>")
                .append(System.lineSeparator()).append("    <body>")
                .append(System.lineSeparator()).append("        <h1>")
                .append(worker.getName()).append("</h1>")
                .append(System.lineSeparator()).append("        <h2>")
                .append(worker.getFired().getTime()).append("</h2>")
                .append(System.lineSeparator()).append("        <h3>")
                .append(worker.getHired().getTime()).append("</h3>")
                .append(System.lineSeparator()).append("        <h4>")
                .append(worker.getSalary()).append("</h4>")
                .append(System.lineSeparator()).append("    </body>")
                .append(System.lineSeparator())
                .append("</html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

}