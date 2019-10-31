package com.autfish._designPatterns.lesson19.mediator;

public class DeliveryMan extends Colleague {

    public DeliveryMan(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        System.out.println("DeliveryMan发出消息: " + message);
        this.mediator.send(message, "DeliveryMan");
    }

    @Override
    public void receive(String message, String from) {
        System.out.println("DeliveryMan收到来自" + from + "的消息: " + message);
    }
}
