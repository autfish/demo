package com.autfish._designPatterns.lesson05.decorator;

public class Painting implements Picture {
    @Override
    public void show() {
        System.out.println("油画原画");
    }
}
