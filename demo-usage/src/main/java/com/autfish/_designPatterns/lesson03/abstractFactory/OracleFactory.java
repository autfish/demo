package com.autfish._designPatterns.lesson03.abstractFactory;

public class OracleFactory implements Factory {
    @Override
    public EmployeeDao getEmployeeDao() {
        return new EmployeeDaoOracleImpl();
    }

    @Override
    public ProductDao getProductDao() {
        return new ProductDaoOracleImpl();
    }
}
