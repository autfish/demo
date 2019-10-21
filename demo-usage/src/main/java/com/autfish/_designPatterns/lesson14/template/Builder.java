package com.autfish._designPatterns.lesson14.template;

public abstract class Builder {

    protected Pizza pizza = new Pizza();

    public abstract void makeCrust();

    public abstract void addIngredients();

    public abstract void addSauce();

    public final void addCheese() {
        System.out.println("加入芝士");
    }

    public final void bake() {
        System.out.println("烘烤");
    }

    public final Pizza build() {
        makeCrust();
        addIngredients();
        addSauce();
        addCheese();
        bake();
        return pizza;
    }
}
