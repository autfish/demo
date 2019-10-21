package com.autfish._designPatterns.lesson07.builder;

public class FruitBuilder extends Builder {
    @Override
    public void makeCrust() {
        pizza.setCrust("芝心");
        System.out.println("制作芝心面饼");
    }

    @Override
    public void addIngredients() {
        pizza.setIngredients("水果");
        System.out.println("加入菠萝");
    }

    @Override
    public void addSauce() {
        pizza.setSauce("芝士");
        System.out.println("加入芝士");
    }

    @Override
    public void bake() {
        System.out.println("中火烤15分钟");
    }
}
