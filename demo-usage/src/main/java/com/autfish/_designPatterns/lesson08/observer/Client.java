package com.autfish._designPatterns.lesson08.observer;

public class Client {

    public static void main(String[] args) {

        Publisher publisher = new Publisher();
        Listener emailListener = new EmailListener();
        publisher.attach(emailListener);
        TokenListener tokenListener = new TokenListener();
        publisher.attach(tokenListener);
        publisher.publish(new LoginEvent("王五"));

        //需求变更，登录不再给金币了
        publisher.detach(tokenListener);
        publisher.publish(new LoginEvent("李四"));
    }
}
