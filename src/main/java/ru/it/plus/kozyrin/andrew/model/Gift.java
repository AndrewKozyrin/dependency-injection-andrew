package ru.it.plus.kozyrin.andrew.model;

public class Gift {

    private final String name;
    private final Integer price;

    public Gift(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
