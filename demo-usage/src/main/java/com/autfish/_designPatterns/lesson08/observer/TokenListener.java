package com.autfish._designPatterns.lesson08.observer;

public class TokenListener implements Listener {
    @Override
    public void onEvent(LoginEvent loginEvent) {
        System.out.println("给" + loginEvent.getName() + "增加10金币");
    }
}
