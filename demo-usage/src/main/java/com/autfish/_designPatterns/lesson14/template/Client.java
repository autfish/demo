package com.autfish._designPatterns.lesson14.template;

public class Client {

    public static void main(String[] args) {

        Builder fruitBuilder = new FruitBuilder();
        Pizza fruitPizza = fruitBuilder.build();
        System.out.println(fruitPizza);

        Builder seafoodBuilder = new SeafoodBuilder();
        Pizza seafoodPizza = seafoodBuilder.build();
        System.out.println(seafoodPizza);
    }
}
