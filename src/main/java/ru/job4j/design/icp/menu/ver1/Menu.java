package ru.job4j.design.icp.menu.ver1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu implements Item {
    private List<Item> list = new ArrayList<>();
    private String name;

    public Menu(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println();
        System.out.println(name);
        for (Item item : list) {
            item.show(list);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Item> getList() {
        return list;
    }

    public void add(Item item) {
        list.add(item);
    }

    public void iterateList(String num) {
        iterateList(list, num);
    }

    public void execute() {
        boolean run = true;
        while (run) {
            show();
            Scanner scanner = new Scanner(System.in);
            String num = scanner.nextLine();
            if (num.equals("стоп")) {
                run = false;
            }
            iterateList(num);
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu("Меню:");
        Item item1 = new Item1("Задача 1.");
        Item item11 = new Item11("--1.1.");
        Item item12 = new Item12("--1.2.");
        Item item111 = new Item111("----1.1.1.");
        Item item112 = new Item112("----1.1.2.");

        item11.add(item111);
        item11.add(item112);
        item1.add(item11);
        item1.add(item12);
        menu.add(item1);

        menu.execute();
    }
}
