package com.autfish._designPatterns.lesson07.builder;

public abstract class Builder {

    protected Pizza pizza = new Pizza();

    public abstract void makeCrust();

    public abstract void addIngredients();

    public abstract void addSauce();

    public abstract void addCheese();

    public abstract void bake();

    public Pizza getPizza() {
        return pizza;
    }
}
