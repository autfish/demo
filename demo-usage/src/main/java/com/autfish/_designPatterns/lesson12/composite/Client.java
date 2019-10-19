package com.autfish._designPatterns.lesson12.composite;

public class Client {

    public static void main(String[] args) {

        CEO ceo = new CEO("Zhang", 100);

        Manager salesManager = new Manager("Wang", 80);
        Manager developmentManager = new Manager("Li", 80);
        ceo.addSubordinate(salesManager);
        ceo.addSubordinate(developmentManager);

        Staff salesman1 = new Staff("Ding", 50);
        Staff salesman2 = new Staff("Yang", 50);
        salesManager.addSubordinate(salesman1);
        salesManager.addSubordinate(salesman2);

        Staff engineer1 = new Staff("Liu", 50);
        Staff engineer2 = new Staff("Chen", 50);
        developmentManager.addSubordinate(engineer1);
        developmentManager.addSubordinate(engineer2);

        System.out.println(ceo.toString());
        for(Employee e : ceo.subordinates) {
            System.out.println("--" + e.toString());
            for(Employee es : e.getSubordinates()) {
                System.out.println("  --" + es.toString());
            }

        }
    }
}
