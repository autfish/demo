package com.autfish._designPatterns.lesson02.factoryMethod;

public class EmployeeDaoOracleFactory implements EmployeeDaoFactory {
    @Override
    public EmployeeDao getEmployeeDao() {
        return new EmployeeDaoOracleImpl();
    }
}
