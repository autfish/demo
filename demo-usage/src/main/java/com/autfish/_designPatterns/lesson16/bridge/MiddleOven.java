package com.autfish._designPatterns.lesson16.bridge;

public class MiddleOven implements Oven {
    @Override
    public String bake() {
        return "9寸";
    }
}
