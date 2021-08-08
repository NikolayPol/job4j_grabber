package ru.job4j.design.icp.ex1;

import java.util.List;

public interface Preserver {
    void saveToFile(List<String> list);

    void saveToDataBse(List<String> list);
}
