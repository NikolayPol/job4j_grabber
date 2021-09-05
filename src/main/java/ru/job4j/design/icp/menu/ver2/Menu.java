package ru.job4j.design.icp.menu.ver2;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Menu содержит пункты меню и методы для добвления, вывода, поиска пунктов меню.
 *
 * @author Nikolay Polegaev
 * @version 2.0
 */
public class Menu {
    private List<Item> list = new ArrayList<>();

    /**
     * Метод add() добавляет пункт в меню.
     * Перебирает всю структуру меню и добавляет
     * потомка child к предку parentName.
     */
    public void add(String parentName, Item child) {
        if (parentName.equals("Menu")) {
            list.add(child);
        } else {
            add(parentName, child, this.list);
        }
    }

    /**
     * Метод add(String parentName, Item child, List<Item> list)
     * является перегруженной версией метода add(String parentName, Item child).
     */
    public void add(String parentName, Item child, List<Item> list) {
        for (Item item : list) {
            if (item.getName().contains(parentName)) {
                item.add(child);
            } else {
                add(parentName, child, item.getItems());
            }
        }
    }

    /**
     * Метод get() по имени пункта меню возвращает его объект.
     */
    public Item get(String name) {
        for (Item item : list) {
            if (item.getName().equals(name)) {
                return item;
            } else {
                get(name, item.getItems());
            }
        }
        return null;
    }

    /**
     * Метод get(String name, List<Item> list) является перегруженной версией метода
     * get(String name) и по имени пункта меню возвращает его объект.
     */
    private Item get(String name, List<Item> list) {
        for (Item item : list) {
            if (item.getName().equals(name)) {
                return item;
            } else {
                get(name, item.getItems());
            }
        }
        return null;
    }

    /**
     * @return list - список дочерних пунктов меню, содержащихся в объекте Menu.
     */
    public List<Item> getList() {
        return list;
    }

    /**
     * Метод print() выводит на консоль структуру меню.
     */
    public void print() {
        for (Item item : list) {
            print(item);
        }
    }

    /**
     * Метод print(Item item) перегруженная версия метода print().
     * выводит на консоль структуру меню.
     */
    private void print(Item item) {
        System.out.println(item.getName());
        for (Item itemChild : item.getItems()) {
            print(itemChild);
        }
    }

    /**
     * Метод printToString() возвращает меню в виде строки.
     */
    public String printToString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : list) {
            if (list != null) {
                sb.append(item.getName()).append(System.lineSeparator());
                sb.append(printToString(item));
            }
        }
        return "Menu{"
                + System.lineSeparator()
                + sb.toString()
                + '}';
    }

    /**
     * Метод printToString(Item item) перешруженная версия метода printToString().
     * Возвращает меню в виде строки.
     */
    private String printToString(Item item) {
        StringBuilder sb = new StringBuilder();
        for (Item itemChild : item.getItems()) {
            if (itemChild.getItems() != null) {
                sb.append(itemChild.getName()).append(System.lineSeparator());
                sb.append(printToString(itemChild));
            }
        }
        return sb.toString();
    }

    /**
     * Метод main() тестирует класс Menu.
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        //создаем структуру меню.
        menu.add("Menu", new Item("--Задача 1.", new PrintAction()));
        menu.add("Menu", new Item("--Задача 2.", new PrintAction()));
        menu.add("--Задача 1.", new Item("  --Задача 1.1.", new PrintAction()));
        menu.add("--Задача 1.", new Item("  --Задача 1.2.", new PrintAction()));
        menu.add("--Задача 2.", new Item("  --Задача 2.1.", new PrintAction()));
        //выведем а консоль структуру меню.
        menu.print();
        //найдем пункт меню по его имени и выведем на консоль
        System.out.println(menu.get("--Задача 1.").getName());
        //выполним действие пункта меню Задача 1.
        menu.get("--Задача 1.").act();
        //выведем меню в строковом представлении
        System.out.println(menu.printToString());
        //выведем на консоль дочерние элементы понктов меню.
//        System.out.println(menu.getList().get(0).getName());
//        System.out.println(menu.getList().get(0).getItems().get(0).getName());
//        System.out.println(menu.getList().get(0).getItems().get(1).getName());
//        System.out.println(menu.getList().get(1).getName());
//        System.out.println(menu.getList().get(1).getItems().get(0).getName());
    }
}
