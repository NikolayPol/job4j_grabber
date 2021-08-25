package ru.job4j.design.srp;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.StringWriter;
import java.util.function.Predicate;

public class BookKeepingReporToHTML extends BookKeepingReport {
    public BookKeepingReporToHTML(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        TemplateEngine templateEngine = new TemplateEngine();
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode("HTML");
        templateEngine.setTemplateResolver(templateResolver);
        for (Employee employee : getStore().findBy(filter)) {
            Context context = new Context();
            context.setVariable("Name", employee.getName());
            context.setVariable("Hired", employee.getHired().getTime());
            context.setVariable("Fired", employee.getFired().getTime());
            context.setVariable("Salary", 0.87 * employee.getSalary());
            StringWriter stringWriter = new StringWriter();
            templateEngine.process("BookKeepingForm.html", context, stringWriter);
            text.append(stringWriter);
        }
        return text.toString();
    }

}
