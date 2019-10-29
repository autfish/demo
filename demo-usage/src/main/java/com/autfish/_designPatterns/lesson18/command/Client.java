package com.autfish._designPatterns.lesson18.command;

public class Client {

    public static void main(String[] args) {

        Chef chef = new Chef();
        Waiter waiter = new Waiter();

        Command pizzaCommand = new PizzaCommand(chef);
        System.out.println("顾客点了披萨");
        waiter.setOrder(pizzaCommand);
        Command saladCommand = new SaladCommand(chef);
        System.out.println("顾客点了沙拉");
        waiter.setOrder(saladCommand);

        waiter.call();
    }
}
