package ru.job4j.design.icp.ex1;

import java.io.File;

public class JsonConverter implements Converter {

    @Override
    public String convertToJson(File file) {
        return null;
    }

    @Override
    public String convertToXml(File file) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String convertToHtml(File file) {
        throw new UnsupportedOperationException();
    }
}
