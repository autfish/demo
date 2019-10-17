package com.autfish._designPatterns.lesson10.facade;

public class TFCard {
    public String readTF() {
        return "从TF卡读取文件";
    }

    public void writeTF(String file) {
        System.out.println("向TF卡写入文件");
    }
}
