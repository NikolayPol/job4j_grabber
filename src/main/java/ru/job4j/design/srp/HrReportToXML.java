package ru.job4j.design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

public class HrReportToXML extends HrReport {

    public HrReportToXML(Store store) {
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
            Map<Double, String> map = new TreeMap<>(Collections.reverseOrder());
            for (Employee employee : getStore().findBy(filter)) {
                map.put(employee.getSalary(), employee.getName());
            }
            for (Double key : map.keySet()) {
                try (StringWriter writer = new StringWriter()) {
                    Employee emp = new Employee(map.get(key), key);
                    marshaller.marshal(emp, writer);
                    text.append(writer.getBuffer().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } catch (
                JAXBException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
