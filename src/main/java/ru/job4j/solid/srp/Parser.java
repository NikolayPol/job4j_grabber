package ru.job4j.solid.srp;

import java.util.List;

public interface Parser {
    List<String> parse();

    String[] convert();

    boolean send();
}
