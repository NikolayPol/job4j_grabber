package ru.job4j.design.srp;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.naming.Context;
import java.util.function.Predicate;

//public class ItReportToHTML extends ItReport {
//
//    public ItReportToHTML(Store store) {
//        super(store);
//    }
//
//    public String generate(Predicate<Employee> filter) {
//        StringBuilder text = new StringBuilder();
//        TemplateEngine templateEngine = new TemplateEngine();
//        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//        templateResolver.setTemplateMode("HTML");
//        templateEngine.setTemplateResolver(templateResolver);
//        for (Employee employee : getStore().findBy(filter)) {
//            Context context = new Context();
//            context.setVariable("Name", employee.getName());
//            context.setVariable("Hired", employee.getHired().getTime());
//            context.setVariable("Fired", employee.getFired().getTime());
//            context.setVariable("Salary", employee.getSalary());
//            StringWriter stringWriter = new StringWriter();
//            templateEngine.process("ItForm.html", context, stringWriter);
//            text.append(stringWriter);
//        }
//        return text.toString();
//    }
//}
