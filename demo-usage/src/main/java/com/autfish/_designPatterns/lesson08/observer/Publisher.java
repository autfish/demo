package com.autfish._designPatterns.lesson08.observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    private List<Listener> listeners = new ArrayList<>();

    public void attach(Listener listener) {
        this.listeners.add(listener);
    }

    public void detach(Listener listener) {
        this.listeners.remove(listener);
    }

    public void publish(LoginEvent loginEvent) {
        System.out.println(loginEvent.getName() + "上线了");
        for(Listener listener : listeners) {
            listener.onEvent(loginEvent);
        }
    }
}
