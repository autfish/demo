package com.autfish._designPatterns.lesson10.facade;

public class UnifiedCardReader {

    private SDCard sdCard;
    private CFCard cfCard;
    private TFCard tfCard;
    private int type;

    public String read() {
        switch (type) {
            case 1:
                return sdCard.readSD();
            case 2:
                return cfCard.readCF();
            case 3:
                return tfCard.readTF();
            default:
                return "没有插入卡";
        }
    }

    public void write(String file) {
        switch (type) {
            case 1:
                sdCard.writeSD(file);
                break;
            case 2:
                cfCard.writeCF(file);
                break;
            case 3:
                tfCard.writeTF(file);
                break;
        }
    }

    public void setSdCard(SDCard sdCard) {
        this.sdCard = sdCard;
        this.type = 1;
    }

    public void setCfCard(CFCard cfCard) {
        this.cfCard = cfCard;
        this.type = 2;
    }

    public void setTfCard(TFCard tfCard) {
        this.tfCard = tfCard;
        this.type = 3;
    }

    public void empty() {
        this.sdCard = null;
        this.cfCard = null;
        this.tfCard = null;
        this.type = 0;
    }
}
