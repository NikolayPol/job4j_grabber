package ru.job4j.design.lsp.ex1;

public class Airplane extends Machine {
    private People people;

    public Airplane() {
    }

    public Airplane(People people) {
        this.people = people;
    }

    @Override
    public void doSomthing() {
        if (people.getClass() == People.class) {
            System.out.println();
            // do something
        } else if (people.getClass() == null) {
            System.out.println();
            // do something
        }
    }
}
