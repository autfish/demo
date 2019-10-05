package com.autfish._designPatterns.lesson02.factoryMethod;

public class EmployeeDaoMySQLFactory implements EmployeeDaoFactory {
    @Override
    public EmployeeDao getEmployeeDao() {
        return new EmployeeDaoMySQLImpl();
    }
}
