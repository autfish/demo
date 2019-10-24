package com.autfish._designPatterns.lesson17.memento;

public class XiaoMing {
    private int money;
    private int age;

    public XiaoMing(int money, int age) {
        this.money = money;
        this.age = age;
    }

    public Memento createMemento() {
        return new Memento(money, age);
    }

    public void restoreMemento(Memento memento) {
        this.money = memento.getMoney();
        this.age = memento.getAge();
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
