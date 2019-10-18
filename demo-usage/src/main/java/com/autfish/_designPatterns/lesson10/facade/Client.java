package com.autfish._designPatterns.lesson10.facade;

public class Client {

    public static void main(String[] args) {

        UnifiedCardReader unifiedCardReader = new UnifiedCardReader();
        unifiedCardReader.setSdCard(new SDCard());
        unifiedCardReader.write("some files");
        System.out.println(unifiedCardReader.read());

        unifiedCardReader.empty();
        unifiedCardReader.setCfCard(new CFCard());
        unifiedCardReader.write("some files");
        System.out.println(unifiedCardReader.read());
    }
}
