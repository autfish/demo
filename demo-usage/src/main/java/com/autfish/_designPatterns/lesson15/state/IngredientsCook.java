package com.autfish._designPatterns.lesson15.state;

public class IngredientsCook extends Cook {
    @Override
    public void cooking(Pizza pizza) {
        if("crust".equals(pizza.getProcess())) {
            pizza.setProcess("crust,ingredients");
            System.out.println("加入馅料");
        } else {
            pizza.setCook(new SauceCook());
            pizza.cooking();
        }
    }
}
