package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.function.Predicate;

public class BookKeepingReport extends ReportEngine {

    public BookKeepingReport(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        //return getEmployess(filter);
        //return xmlConverter(filter);
        return jsonConverter(filter);
        //return htmlConverter(filter);
    }

    private String getEmployess(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;" + System.lineSeparator());
        for (Employee employee : getStore().findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired().getTime()).append(";")
                    .append(employee.getFired().getTime()).append(";")
                    .append(0.87 * employee.getSalary()).append(";")
                    .append(System.lineSeparator());
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
                employee.setSalary(0.87 * employee.getSalary());
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

    private String jsonConverter(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        for (Employee employee : getStore().findBy(filter)) {
            employee.setSalary(0.87 * employee.getSalary());
            Gson gson = new GsonBuilder().create();
            text.append(gson.toJson(employee) + System.lineSeparator());
        }
        return text.toString();
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
            context.setVariable("Salary", 0.87 * employee.getSalary());
            StringWriter stringWriter = new StringWriter();
            templateEngine.process("BookKeepingForm.html", context, stringWriter);
            text.append(stringWriter);
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
        System.out.println(engine.generate(em -> true));
    }
}
