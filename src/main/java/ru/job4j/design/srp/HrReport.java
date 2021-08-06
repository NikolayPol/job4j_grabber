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
import java.util.*;
import java.util.function.Predicate;

public class HrReport extends ReportEngine {

    public HrReport(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        //return getNameAndSalary(filter);
        //return xmlConverter(filter);
        return jsonConverter(filter);
        //return htmlConverter(filter);
    }

    private String getNameAndSalary(Predicate<Employee> filter) {
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

    private String xmlConverter(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Employee.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            Map<Double, String> map = new TreeMap<Double, String>(Collections.reverseOrder());
            for (Employee employee : getStore().findBy(filter)) {
                map.put(employee.getSalary(), employee.getName());
            }
            for (Double key : map.keySet()) {
                try (StringWriter writer = new StringWriter()) {
                    Employee emp = new Employee(map.get(key), key);
                    marshaller.marshal(emp, writer);
                    text.append(writer.getBuffer().toString());
                } catch (Exception e) {
                }

            }
        } catch (
                JAXBException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    private String jsonConverter(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        Map<Double, String> map = new TreeMap<Double, String>(Collections.reverseOrder());
        for (Employee employee : getStore().findBy(filter)) {
            map.put(employee.getSalary(), employee.getName());
        }
        for (Double key : map.keySet()) {
            Gson gson = new GsonBuilder().create();
            Employee emp = new Employee(map.get(key), key);
            text.append(gson.toJson(emp) + System.lineSeparator());
        }
        return text.toString();
    }

    private String htmlConverter(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        TemplateEngine templateEngine = new TemplateEngine();
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode("HTML");
        templateEngine.setTemplateResolver(templateResolver);
        Map<Double, String> map = new TreeMap<Double, String>(Collections.reverseOrder());
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

    public static void main(String[] args) {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Petr", now, now, 300);
        Employee worker3 = new Employee("Boris", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new HrReport(store);
        System.out.println(engine.generate(em -> true));
    }
}
