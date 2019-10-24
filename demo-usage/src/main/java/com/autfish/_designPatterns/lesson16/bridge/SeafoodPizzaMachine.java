package com.autfish._designPatterns.lesson16.bridge;

public class SeafoodPizzaMachine extends PizzaMachine {
    @Override
    public String bake() {
        return oven.bake() + "海鲜披萨";
    }
}
