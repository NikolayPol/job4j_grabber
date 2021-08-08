package ru.job4j.design.icp.ex1;

import java.io.File;

public class HtmlConverter implements Converter {
    @Override
    public String convertToJson(File file) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String convertToXml(File file) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String convertToHtml(File file) {
        return null;
    }
}
