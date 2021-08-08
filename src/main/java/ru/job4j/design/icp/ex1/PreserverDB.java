package ru.job4j.design.icp.ex1;

import java.util.List;

public class PreserverDB implements Preserver {
    @Override
    public void saveToFile(List<String> list) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void saveToDataBse(List<String> list) {

    }
}
