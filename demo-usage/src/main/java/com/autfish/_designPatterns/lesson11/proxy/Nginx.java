package com.autfish._designPatterns.lesson11.proxy;

public class Nginx implements WebServer {

    private Tomcat tomcat;

    public Nginx() {
    }

    @Override
    public String getHttp() {
        if(tomcat == null) {
            tomcat = new Tomcat();
        }
        return tomcat.getHttp();
    }
}
