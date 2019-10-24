package com.autfish._designPatterns.lesson16.bridge;

public class SmallOven implements Oven {
    @Override
    public String bake() {
        return "6寸";
    }
}
