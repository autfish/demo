package com.autfish._designPatterns.lesson10.facade;

public class CFCard {
    public String readCF() {
        return "从CF卡读取文件";
    }

    public void writeCF(String file) {
        System.out.println("向CF卡写入文件");
    }
}
