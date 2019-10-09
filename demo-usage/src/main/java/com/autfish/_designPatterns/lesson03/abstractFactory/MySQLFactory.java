package com.autfish._designPatterns.lesson03.abstractFactory;

public class MySQLFactory implements Factory {
    @Override
    public EmployeeDao getEmployeeDao() {
        return new EmployeeDaoMySQLImpl();
    }

    @Override
    public ProductDao getProductDao() {
        return new ProductDaoMySQLImpl();
    }
}
