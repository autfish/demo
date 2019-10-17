package com.autfish._designPatterns.lesson10.facade;

public class SDCard {

    public String readSD() {
        return "从SD卡读取文件";
    }

    public void writeSD(String file) {
        System.out.println("向SD卡写入文件");
    }
}
