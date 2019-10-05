package com.autfish._designPatterns.lesson02.factoryMethod;


public class Client {

    public static void main(String[] args) {
        EmployeeDaoFactory employeeDaoFactory = new EmployeeDaoMySQLFactory();
        Employee employee = employeeDaoFactory.getEmployeeDao().selectById(1);

        employeeDaoFactory = new EmployeeDaoOracleFactory();
        employee = employeeDaoFactory.getEmployeeDao().selectById(2);
    }
}
