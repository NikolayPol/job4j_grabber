package ru.job4j.design.srp;

import java.io.StringWriter;
import java.util.Calendar;
import java.util.function.Predicate;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ItReport extends ReportEngine {

    public ItReport(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        //return xmlConverter(filter);
        return htmlConverter(filter);
    }

    private String htmlConverter(Predicate<Employee> filter) {
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
            context.setVariable("Salary", employee.getSalary());
            StringWriter stringWriter = new StringWriter();
            templateEngine.process("test.html", context, stringWriter);
            text.append(stringWriter);
        }
        return text.toString();
    }

    private String xmlConverter(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Employee.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            for (Employee employee : getStore().findBy(filter)) {
                try (StringWriter writer = new StringWriter()) {
                    marshaller.marshal(employee, writer);
                    text.append(writer.getBuffer().toString());
                } catch (Exception e) {

                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    public static void main(String[] args) {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Petr", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        Report engine = new ItReport(store);
        System.out.println(engine.generate(em -> true));
    }
}
