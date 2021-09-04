//package ru.job4j.template;
//
//import static org.junit.Assert.assertThat;
//import static org.hamcrest.Matchers.is;
//
//import org.junit.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class GeneratorTest {
//    @Test
//    public void produceTest() {
//        Generator generator = new GeneratorTemplate();
//        String template = "I am a ${name}, Who are ${subject}? ";
//        String actual = "I am a Petr Arsentev, Who are you? ";
//        Map<String, String> args = new HashMap<>();
//        args.put("name", "Petr Arsentev");
//        args.put("subject", "you");
//        String expected = generator.produce(template, args);
//        //assertThat(expected, is(actual));
//    }
//
//    @Test(expected = Exception.class)
//    public void IncorrectArgumentsLessTest() {
//        Generator generator = new GeneratorTemplate();
//        String template = "I am a ${name}, Who are ${subject}? ";
//        String actual = "I am a Petr Arsentev, Who are you? ";
//        Map<String, String> args = new HashMap<>();
//        args.put("name", "Petr Arsentev");
//        String expected = generator.produce(template, args);
//    }
//
//    @Test(expected = Exception.class)
//    public void IncorrectArgumentsMoreTest() {
//        Generator generator = new GeneratorTemplate();
//        String template = "I am a ${name}, Who are ${subject}? ";
//        String actual = "I am a Petr Arsentev, Who are you? ";
//        Map<String, String> args = new HashMap<>();
//        args.put("name", "Petr Arsentev");
//        args.put("subject", "you");
//        args.put("address", "address");
//        String expected = generator.produce(template, args);
//    }
//
//    @Test(expected = Exception.class)
//    public void IncorrectArgumentsNoSuchInTemplateTest() {
//        Generator generator = new GeneratorTemplate();
//        String template = "I am a ${name}, Who are ${subject}? ";
//        String actual = "I am a Petr Arsentev, Who are you? ";
//        Map<String, String> args = new HashMap<>();
//        args.put("number", "Petr Arsentev");
//        args.put("123", "you");
//        String expected = generator.produce(template, args);
//    }
//}