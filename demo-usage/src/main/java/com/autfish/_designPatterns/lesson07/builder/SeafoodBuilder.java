package com.autfish._designPatterns.lesson07.builder;

public class SeafoodBuilder extends Builder {

    @Override
    public void makeCrust() {
        pizza.setCrust("经典手拍");
        System.out.println("制作经典手拍面饼");
    }

    @Override
    public void addIngredients() {
        pizza.setIngredients("海鲜");
        System.out.println("加入海鲜馅料");
    }

    @Override
    public void addSauce() {
        pizza.setSauce("香辣酱");
        System.out.println("加入香辣酱");
    }

    @Override
    public void addCheese() {
        System.out.println("加入芝士");
    }

    @Override
    public void bake() {
        System.out.println("烘烤");
    }
}
