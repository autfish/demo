package com.autfish._designPatterns.lesson05.decorator;

public abstract class Filter implements Picture {
    protected Picture picture;

    public Filter(Picture picture) {
        this.picture = picture;
    }
}
