package com.autfish._designPatterns.lesson03.abstractFactory;

public interface Factory {

    EmployeeDao getEmployeeDao();

    ProductDao getProductDao();
}
