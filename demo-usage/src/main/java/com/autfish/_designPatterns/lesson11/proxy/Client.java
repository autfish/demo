package com.autfish._designPatterns.lesson11.proxy;

public class Client {

    public static void main(String[] args) {

        Nginx nginx = new Nginx();
        System.out.println(nginx.getHttp());
    }
}
