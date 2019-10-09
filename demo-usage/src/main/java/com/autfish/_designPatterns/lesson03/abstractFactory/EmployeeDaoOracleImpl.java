package com.autfish._designPatterns.lesson03.abstractFactory;

public class EmployeeDaoOracleImpl implements EmployeeDao {
    @Override
    public Employee selectById(int id) {
        System.out.println("EmployeeDaoOracleImpl::selectById");
        return new Employee();
    }
}
