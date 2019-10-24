package com.autfish._designPatterns.lesson16.bridge;

public class FruitsPizzaMachine extends PizzaMachine {
    @Override
    public String bake() {
        return oven.bake() + "水果披萨";
    }
}
