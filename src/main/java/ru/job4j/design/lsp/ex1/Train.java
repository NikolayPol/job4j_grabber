package ru.job4j.design.lsp.ex1;

public class Train extends Machine {
    private String type;

    public Train(String type) {
        this.type = type;
    }

    @Override
    public void doSomthing() {
        if (type.equals("passenger")) {
            System.out.println(1);
        } else if (type.equals("freight")) {
            System.out.println(2);
        }
    }
}
