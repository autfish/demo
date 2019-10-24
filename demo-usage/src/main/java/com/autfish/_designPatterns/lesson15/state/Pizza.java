package com.autfish._designPatterns.lesson15.state;

public class Pizza {

    private String process;
    private Cook cook;

    public Pizza() {
        this.process = "";
        this.cook = new CrustCook();
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }

    public void cooking() {
        this.cook.cooking(this);
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }
}
