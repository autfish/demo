package com.autfish._designPatterns.lesson16.bridge;

public abstract class PizzaMachine {
    protected Oven oven;

    public void setOven(Oven oven) {
        this.oven = oven;
    }

    public abstract String bake();
}
