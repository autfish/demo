package com.autfish._designPatterns.lesson15.state;

public class BakeCook extends Cook {
    @Override
    public void cooking(Pizza pizza) {
        if("crust,ingredients,sauce,cheese".equals(pizza.getProcess())) {
            System.out.println("制作完成");
        } else {
            System.out.println("制作失败");
        }
    }
}
