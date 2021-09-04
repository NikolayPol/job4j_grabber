package ru.job4j.cache;

import java.util.Scanner;

public class Emulator extends DirFileCache {

    public Emulator(String cachingDir) {
        super(cachingDir);
    }

    public void setCachingDir(String cachingDir) {
        super.setCachingDir(cachingDir);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Создаем объект Emulator и указываем кэшируемую директорию
        Emulator emulator = new Emulator("src/main/java/ru/job4j/cache/");
        // получить содержимое файла из кэша
        System.out.print("Введите имя файла: ");
        String input = scanner.nextLine();
        System.out.println("Содержание файла: \n" + emulator.get(input));
    }
}
