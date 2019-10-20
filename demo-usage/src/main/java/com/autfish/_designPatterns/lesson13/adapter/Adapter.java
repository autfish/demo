package com.autfish._designPatterns.lesson13.adapter;

public class Adapter implements Charger {

    private ChinaCharger chinaCharger;

    public Adapter() {
        this.chinaCharger = new ChinaCharger();
    }

    @Override
    public void chargeBy110V() {
        chinaCharger.chargeBy220V();
    }
}
