package ru.job4j.design.srp.ex1;

import java.util.List;

public interface Parser {
    List<String> parse();

    String[] convert();

    boolean send();
}
