package ru.job4j.design.icp.menu.ver2;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Action {
    private List<Item> list = new ArrayList<>();

    public void add(String parentName, Item child) {
        if (parentName.equals("Menu")) {
            list.add(child);
        } else {
            iterateList(parentName, list, child);
        }
    }

    public Item get(String name) {
        return null;
    }

    public List<Item> getList() {
        return list;
    }

    private String print() {
        StringBuilder sb = new StringBuilder();
        return iterateName(list);
        //act();
    }

    @Override
    public void act() {
//        boolean run = true;
//        while (run) {
//            System.out.println();
//            Scanner scanner = new Scanner(System.in);
//            String num = scanner.nextLine();
//            if (num.equals("стоп")) {
//                run = false;
//            }
//            iterateList(num);
//        }
    }

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.add("Menu", new Item("--Задача 1."));
        menu.add("Menu", new Item("--Задача 2."));
        menu.add("--Задача 1.", new Item("----Задача 1.1."));
        menu.add("--Задача 1.", new Item("----Задача 1.2."));
        menu.add("--Задача 2.", new Item("----Задача 2.1."));
        menu.print();
//        System.out.println(menu.getList().get(0).getName());
//        System.out.println(menu.getList().get(1).getName());
//        System.out.println(menu.getList().get(0).getItems().get(0).getName());
//        System.out.println(menu.getList().get(0).getItems().get(1).getName());
//        System.out.println(menu.getList().get(1).getItems().get(0).getName());
    }

}
