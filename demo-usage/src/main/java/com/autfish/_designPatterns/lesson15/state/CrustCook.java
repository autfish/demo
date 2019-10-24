package com.autfish._designPatterns.lesson15.state;

public class CrustCook extends Cook {
    @Override
    public void cooking(Pizza pizza) {
        if (pizza.getProcess().equals("")) {
            pizza.setProcess("crust");
            System.out.println("制作面饼");
        } else {
            pizza.setCook(new IngredientsCook());
            pizza.cooking();
        }
    }
}
