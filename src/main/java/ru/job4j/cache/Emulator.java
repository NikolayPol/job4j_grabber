package ru.job4j.cache;

public class Emulator extends DirFileCache {

    public Emulator(String cachingDir) {
        super(cachingDir);
    }

    public void setCachingDir(String cachingDir) {
        super.setCachingDir(cachingDir);
    }

    public static void main(String[] args) {
        Emulator emulator = new Emulator("src/main/java/ru/job4j/cache/");
        // указать кэшируемую директорию
        emulator.setCachingDir("src/main/java/ru/job4j/cache/");
        // загрузить содержимое файла в кэш
        emulator.load("Names.txt");
        // получить содержимое файла из кэша
        System.out.println(emulator.get("Address.txt"));
    }
}
