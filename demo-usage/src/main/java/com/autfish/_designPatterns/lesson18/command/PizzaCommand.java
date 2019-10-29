package com.autfish._designPatterns.lesson18.command;

public class PizzaCommand implements Command {

    private Chef chef;

    public PizzaCommand(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void execute() {
        chef.cookPizza();
    }
}
