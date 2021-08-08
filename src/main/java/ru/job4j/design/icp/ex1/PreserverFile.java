package ru.job4j.design.icp.ex1;

import java.util.List;

public class PreserverFile implements Preserver {
    @Override
    public void saveToFile(List<String> list) {

    }

    @Override
    public void saveToDataBse(List<String> list) {
        throw new UnsupportedOperationException();
    }
}
