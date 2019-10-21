package com.autfish._designPatterns.lesson07.builder;

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Pizza build() {
        builder.makeCrust();
        builder.addIngredients();
        builder.addSauce();
        builder.bake();
        return builder.getPizza();
    }
}
