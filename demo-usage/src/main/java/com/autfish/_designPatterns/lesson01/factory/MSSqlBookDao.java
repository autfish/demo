package com.autfish._designPatterns.lesson01.factory;

public class MSSqlBookDao implements BookDao {

    @Override
    public Book selectById(int id) {
        System.out.println("MSSqlBookDao::selectById");
        return new Book();
    }
}
