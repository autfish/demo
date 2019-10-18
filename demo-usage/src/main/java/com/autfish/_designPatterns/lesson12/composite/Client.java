package com.autfish._designPatterns.lesson12.composite;

public class Client {

    public static void main(String[] args) {

        CEO ceo = new CEO("Zhang", 100);

        Manager salesDirector = new Manager("Wang", 80);
        Manager developmentDirector = new Manager("Li", 80);
        ceo.addSubordinate(salesDirector);
        ceo.addSubordinate(developmentDirector);

        Staff salesman1 = new Staff("Ding", 50);
        Staff salesman2 = new Staff("Yang", 50);
        salesDirector.addSubordinate(salesman1);
        salesDirector.addSubordinate(salesman2);

        Staff engineer1 = new Staff("Liu", 50);
        Staff engineer2 = new Staff("Chen", 50);
        developmentDirector.addSubordinate(engineer1);
        developmentDirector.addSubordinate(engineer2);
    }
}
