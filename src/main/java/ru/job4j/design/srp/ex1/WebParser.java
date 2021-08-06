package ru.job4j.design.srp.ex1;

import java.util.List;

public class WebParser implements Parser {
    @Override
    public List<String> parse() {
        return null;
    }

    @Override
    public String[] convert() {
        return new String[0];
    }

    @Override
    public boolean send() {
        return false;
    }
}
