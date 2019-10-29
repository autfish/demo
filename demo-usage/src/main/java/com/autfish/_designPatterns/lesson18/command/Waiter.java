package com.autfish._designPatterns.lesson18.command;

import java.util.ArrayList;
import java.util.List;

public class Waiter {

    private List<Command> commandList = new ArrayList<>();

    public void setOrder(Command command) {
        commandList.add(command);
    }

    public void call() {
        System.out.println("下单");
        for(Command command : commandList) {
            command.execute();
        }
    }
}
