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
        pizza.setSauce("番茄酱");
        System.out.println("加入番茄酱");
    }

    @Override
    public void bake() {
        System.out.println("大火烤30分钟");
    }
}
