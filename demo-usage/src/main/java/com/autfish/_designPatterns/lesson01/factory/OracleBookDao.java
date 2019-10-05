package com.autfish._designPatterns.lesson01.factory;

public class OracleBookDao implements BookDao {

    @Override
    public Book selectById(int id) {
        System.out.println("OracleBookDao::selectById");
        return new Book();
    }
}
