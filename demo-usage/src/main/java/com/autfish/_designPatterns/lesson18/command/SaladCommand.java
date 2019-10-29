package com.autfish._designPatterns.lesson18.command;

public class SaladCommand implements Command {

    private Chef chef;

    public SaladCommand(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void execute() {
        chef.cookSalad();
    }
}
