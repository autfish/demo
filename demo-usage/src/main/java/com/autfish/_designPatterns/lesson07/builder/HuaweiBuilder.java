package com.autfish._designPatterns.lesson07.builder;

public class HuaweiBuilder implements Builder {

    @Override
    public boolean checkOrder(Order order) {
        System.out.println("HuaweiBuilder::checkOrder");
        return true;
    }

    @Override
    public boolean chechSign(Order order) {
        System.out.println("HuaweiBuilder::chechSign");
        return true;
    }

    @Override
    public void log(Order order) {
        System.out.println("HuaweiBuilder::log");
    }

    @Override
    public void updateOrder(Order order) {
        System.out.println("HuaweiBuilder::updateOrder");
    }

    @Override
    public void distribute(Order order) {
        System.out.println("HuaweiBuilder::distribute");
    }
}
