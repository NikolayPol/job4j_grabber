package ru.job4j.design.srp;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.StringWriter;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

public class HrReportToHTML extends HrReport {

    public HrReportToHTML(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {

        StringBuilder text = new StringBuilder();
        TemplateEngine templateEngine = new TemplateEngine();
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode("HTML");
        templateEngine.setTemplateResolver(templateResolver);
        Map<Double, String> map = new TreeMap<>(Collections.reverseOrder());
        for (Employee employee : getStore().findBy(filter)) {
            map.put(employee.getSalary(), employee.getName());
        }
        for (Double key : map.keySet()) {
            Context context = new Context();
            context.setVariable("Name", map.get(key));
            context.setVariable("Salary", key);
            StringWriter stringWriter = new StringWriter();
            templateEngine.process("HrForm.html", context, stringWriter);
            text.append(stringWriter);
        }
        return text.toString();
    }
}
