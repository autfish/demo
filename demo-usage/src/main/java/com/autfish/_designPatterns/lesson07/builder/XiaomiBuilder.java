package com.autfish._designPatterns.lesson07.builder;

public class XiaomiBuilder implements Builder {
    @Override
    public boolean checkOrder(Order order) {
        System.out.println("XiaomiBuilder::checkOrder");
        return true;
    }

    @Override
    public boolean chechSign(Order order) {
        System.out.println("XiaomiBuilder::chechSign");
        return true;
    }

    @Override
    public void log(Order order) {
        System.out.println("XiaomiBuilder::log");
    }

    @Override
    public void updateOrder(Order order) {
        System.out.println("XiaomiBuilder::updateOrder");
    }

    @Override
    public void distribute(Order order) {
        System.out.println("XiaomiBuilder::distribute");
    }
}
