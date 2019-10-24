package com.autfish._designPatterns.lesson17.memento;

public class Memento {

    private int money;
    private int age;

    public Memento(int money, int age) {
        this.money = money;
        this.age = age;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
