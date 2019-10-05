package com.autfish._designPatterns.lesson02.factoryMethod;

public class EmployeeDaoMySQLImpl implements EmployeeDao {
    @Override
    public Employee selectById(int id) {
        System.out.println("EmployeeDaoMySQLImpl::selectById");
        return new Employee();
    }
}
