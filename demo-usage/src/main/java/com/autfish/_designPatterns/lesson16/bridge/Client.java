package com.autfish._designPatterns.lesson16.bridge;

public class Client {

    public static void main(String[] args) {

        PizzaMachine pizzaMachine = new SeafoodPizzaMachine();
        pizzaMachine.setOven(new BigOven());
        System.out.println(pizzaMachine.bake());

        pizzaMachine.setOven(new SmallOven());
        System.out.println(pizzaMachine.bake());

        pizzaMachine = new FruitsPizzaMachine();
        pizzaMachine.setOven(new MiddleOven());
        System.out.println(pizzaMachine.bake());
    }
}
