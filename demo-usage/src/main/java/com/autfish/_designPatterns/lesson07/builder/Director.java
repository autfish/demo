package com.autfish._designPatterns.lesson07.builder;

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public boolean build(Order order) {
        boolean success = builder.checkOrder(order);
        if(!success) {
            return false;
        }
        success = builder.chechSign(order);
        if(!success) {
            return false;
        }
        builder.log(order);
        builder.updateOrder(order);
        builder.distribute(order);
        return true;
    }
}
