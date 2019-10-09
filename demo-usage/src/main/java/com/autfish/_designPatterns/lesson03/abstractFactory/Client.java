package com.autfish._designPatterns.lesson03.abstractFactory;

public class Client {

    public static void main(String[] args) {

        System.out.println("use MySQL");
        Factory factory = new MySQLFactory();
        factory.getEmployeeDao().selectById(1);
        factory.getProductDao().selectById(1);

        System.out.println("use Oracle");
        factory = new OracleFactory();
        factory.getEmployeeDao().selectById(1);
        factory.getProductDao().selectById(1);
    }
}
