package com.autfish._designPatterns.lesson07.builder;

public class Client {

    public static void main(String[] args) {

        Director director = new Director(new XiaomiBuilder());
        director.build(new Order());
    }
}
