package ru.job4j.template;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GeneratorTest {
    @Test
    public void produceTest() {
        Generator generator = new GeneratorTemplate();
        String template = "I am a ${name}, Who are ${subject}? ";
        String actual = "I am a Petr Arsentev, Who are you? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        String expected = generator.produce(template, args);
        assertThat(expected, is(actual));
    }
}