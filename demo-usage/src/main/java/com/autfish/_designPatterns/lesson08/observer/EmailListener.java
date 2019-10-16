package com.autfish._designPatterns.lesson08.observer;

public class EmailListener implements Listener {
    @Override
    public void onEvent(LoginEvent loginEvent) {
        System.out.println("给" + loginEvent.getName() + "发送了一封邮件");
    }
}
