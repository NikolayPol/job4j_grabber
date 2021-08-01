package ru.job4j.cache;

public class Emulator extends DirFileCache {

    public Emulator(String cachingDir) {
        super(cachingDir);
    }

    public static void main(String[] args) {
        Emulator emulator = new Emulator("Names.txt, Address.txt");
        System.out.println(emulator.get("Names.txt"));
    }
}
