package ru.job4j.design.icp.ex1;

import java.io.File;

public class XmlConverter implements Converter {
    @Override
    public String convertToJson(File file) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String convertToXml(File file) {
        return null;
    }

    @Override
    public String convertToHtml(File file) {
        throw new UnsupportedOperationException();
    }
}
