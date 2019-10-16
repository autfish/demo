package com.autfish._designPatterns.lesson08.observer;

import java.util.EventObject;

public class LoginEvent extends EventObject {
    public LoginEvent(String name) {
        super(name);
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
