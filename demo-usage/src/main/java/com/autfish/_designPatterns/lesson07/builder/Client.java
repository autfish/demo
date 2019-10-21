package com.autfish._designPatterns.lesson07.builder;

public class Client {

    public static void main(String[] args) {

        Director director = new Director(new FruitBuilder());
        Pizza fruitPizza = director.build();
        System.out.println("制作完成: " + fruitPizza);

        director = new Director(new SeafoodBuilder());
        Pizza seafoodPizza = director.build();
        System.out.println("制作完成: " + seafoodPizza);
    }
}
