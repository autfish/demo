package com.autfish._designPatterns.lesson01.factory;

public class Client {

    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoFactory().getEmployeeDao("ORACLE");
        Employee employee = employeeDao.selectById(1);
    }
}
