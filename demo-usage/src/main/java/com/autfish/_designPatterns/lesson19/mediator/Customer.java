package com.autfish._designPatterns.lesson19.mediator;

public class Customer extends Colleague {

    public Customer(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        System.out.println("Customer发出消息: " + message);
        this.mediator.send(message, "Customer");
    }

    @Override
    public void receive(String message, String from) {
        System.out.println("Customer收到来自" + from + "的消息: " + message);
    }
}
