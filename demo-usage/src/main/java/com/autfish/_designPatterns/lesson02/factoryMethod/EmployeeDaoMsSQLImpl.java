package com.autfish._designPatterns.lesson02.factoryMethod;

public class EmployeeDaoMsSQLImpl implements EmployeeDao {

    @Override
    public Employee selectById(int id) {
        System.out.println("EmployeeDaoMsSQLImpl::selectById");
        return new Employee();
    }
}
