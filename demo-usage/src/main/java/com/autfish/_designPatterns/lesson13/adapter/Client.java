package com.autfish._designPatterns.lesson13.adapter;

public class Client {

    public static void main(String[] args) {
        Charger charger = new Adapter();
        charger.chargeBy110V();
    }
}
