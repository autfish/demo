package com.autfish._designPatterns.lesson01.factory;

public class EmployeeDaoMsSQLImpl implements EmployeeDao {

    @Override
    public Employee selectById(int id) {
        System.out.println("EmployeeDaoMsSQLImpl::selectById");
        return new Employee();
    }
}
