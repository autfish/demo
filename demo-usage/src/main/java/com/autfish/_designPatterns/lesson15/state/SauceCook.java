package com.autfish._designPatterns.lesson15.state;

public class SauceCook extends Cook {
    @Override
    public void cooking(Pizza pizza) {
        if("crust,ingredients".equals(pizza.getProcess())) {
            pizza.setProcess("crust,ingredients,sauce");
            System.out.println("加入酱料");
        } else {
            pizza.setCook(new CheeseCook());
            pizza.cooking();
        }
    }
}
