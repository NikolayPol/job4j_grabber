package ru.job4j.design.icp.ex1;

import java.io.File;

public interface Converter {
    String convertToJson(File file);

    String convertToXml(File file);

    String convertToHtml(File file);
}
