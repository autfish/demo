package com.autfish._designPatterns.lesson15.state;

public class CheeseCook extends Cook {
    @Override
    public void cooking(Pizza pizza) {
        if("crust,ingredients,sauce".equals(pizza.getProcess())) {
            pizza.setProcess("crust,ingredients,sauce,cheese");
            System.out.println("加入芝士");
        } else {
            pizza.setCook(new BakeCook());
            pizza.cooking();
        }
    }
}
