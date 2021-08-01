package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
        String[] arr = cachingDir.replace(",", "").split(" ");
        for (String key : arr) {
            load(key);
        }
    }

    @Override
    protected String load(String key) {
        String text = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(
                    "src/main/java/ru/job4j/cache/" + key));
            text = br.lines().collect(Collectors.joining(System.lineSeparator()));
            super.put(key, text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return text;
    }
}
