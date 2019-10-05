package com.autfish._designPatterns.lesson01.factory;

public class EmployeeDaoMySQLImpl implements EmployeeDao {
    @Override
    public Employee selectById(int id) {
        System.out.println("EmployeeDaoMySQLImpl::selectById");
        return new Employee();
    }
}
