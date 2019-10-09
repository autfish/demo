package com.autfish._designPatterns.lesson03.abstractFactory;

public class ProductDaoOracleImpl implements ProductDao {
    @Override
    public Product selectById(int id) {
        System.out.println("ProductDaoOracleImpl::selectById");
        return new Product();
    }
}
