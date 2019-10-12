package com.autfish._designPatterns.lesson04.singleton;

public class LazySingleton {

    private static LazySingleton instance;
    private static Object lock = new Object();

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if(instance == null) {
            synchronized (lock) {
                if(instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
