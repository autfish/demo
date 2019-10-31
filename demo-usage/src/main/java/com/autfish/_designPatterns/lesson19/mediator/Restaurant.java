package com.autfish._designPatterns.lesson19.mediator;

public class Restaurant extends Colleague {
    public Restaurant(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        System.out.println("Restaurant发出消息: " + message);
        this.mediator.send(message, "Restaurant");
    }

    @Override
    public void receive(String message, String from) {
        System.out.println("Restaurant收到来自" + from + "的消息: " + message);
    }
}
