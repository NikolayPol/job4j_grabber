package ru.job4j.design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.function.Predicate;

public class BookKeepingReporToXML extends BookKeepingReport {

    public BookKeepingReporToXML(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        JAXBContext context;
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
                    e.printStackTrace();
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}

