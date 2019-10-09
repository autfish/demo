package com.autfish._designPatterns.lesson03.abstractFactory;

public class ProductDaoMySQLImpl implements ProductDao {
    @Override
    public Product selectById(int id) {
        System.out.println("ProductDaoMySQLImpl::selectById");
        return new Product();
    }
}
