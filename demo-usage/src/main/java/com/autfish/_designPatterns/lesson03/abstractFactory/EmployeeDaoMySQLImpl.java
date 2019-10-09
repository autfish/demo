package com.autfish._designPatterns.lesson03.abstractFactory;

public class EmployeeDaoMySQLImpl implements EmployeeDao {
    @Override
    public Employee selectById(int id) {
        System.out.println("EmployeeDaoMySQLImpl::selectById");
        return new Employee();
    }
}
