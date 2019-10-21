package com.autfish._designPatterns.lesson14.template;

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
}
