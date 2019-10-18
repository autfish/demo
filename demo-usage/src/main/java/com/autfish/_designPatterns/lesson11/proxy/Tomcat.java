package com.autfish._designPatterns.lesson11.proxy;

public class Tomcat implements WebServer {

    @Override
    public String getHttp() {
        return "GET /index HTTP/1.1";
    }
}
