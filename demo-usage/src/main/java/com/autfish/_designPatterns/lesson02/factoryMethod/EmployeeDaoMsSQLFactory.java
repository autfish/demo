package com.autfish._designPatterns.lesson02.factoryMethod;

public class EmployeeDaoMsSQLFactory implements EmployeeDaoFactory {
    @Override
    public EmployeeDao getEmployeeDao() {
        return new EmployeeDaoMsSQLImpl();
    }
}
