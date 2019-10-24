package com.autfish._designPatterns.lesson16.bridge;

public class BigOven implements Oven {
    @Override
    public String bake() {
        return "12寸";
    }
}
