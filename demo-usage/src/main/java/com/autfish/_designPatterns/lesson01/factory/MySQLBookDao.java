package com.autfish._designPatterns.lesson01.factory;

public class MySQLBookDao implements BookDao {
    @Override
    public Book selectById(int id) {
        System.out.println("MySQLBookDao::selectById");
        return new Book();
    }
}
