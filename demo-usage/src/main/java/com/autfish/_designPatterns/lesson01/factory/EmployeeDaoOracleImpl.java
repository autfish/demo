package com.autfish._designPatterns.lesson01.factory;

public class EmployeeDaoOracleImpl implements EmployeeDao {

    @Override
    public Employee selectById(int id) {
        System.out.println("EmployeeDaoOracleImpl::selectById");
        return new Employee();
    }
}
