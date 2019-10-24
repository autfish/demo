package com.autfish._designPatterns.lesson15.state;

public class Client {

    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        pizza.cooking();
        pizza.cooking();
        pizza.cooking();
        pizza.cooking();
        pizza.cooking();
    }
}
