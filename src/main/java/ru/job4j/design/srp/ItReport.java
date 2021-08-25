package ru.job4j.design.srp;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.function.Predicate;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ItReport extends ReportEngine {
    public ItReport(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
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
                templateEngine.process("ItForm.html", context, stringWriter);
                text.append(stringWriter);
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