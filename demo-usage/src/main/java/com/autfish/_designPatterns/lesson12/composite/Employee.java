package com.autfish._designPatterns.lesson12.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee {

    protected String name;
    protected int salary;
    protected List<Employee> subordinates = new ArrayList<>();

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public String toString() {
        return "[name: " + name + "; salary:" + salary + "]";
    }
}
