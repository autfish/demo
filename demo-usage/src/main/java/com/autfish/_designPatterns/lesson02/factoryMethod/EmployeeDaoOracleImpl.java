package com.autfish._designPatterns.lesson02.factoryMethod;

public class EmployeeDaoOracleImpl implements EmployeeDao {

    @Override
    public Employee selectById(int id) {
        System.out.println("EmployeeDaoOracleImpl::selectById");
        return new Employee();
    }
}
