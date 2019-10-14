package com.autfish._designPatterns.lesson07.builder;

public interface Builder {

    boolean checkOrder(Order order);

    boolean chechSign(Order order);

    void log(Order order);

    void updateOrder(Order order);

    void distribute(Order order);
}
