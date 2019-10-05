package com.autfish._designPatterns.lesson01.factory;

public class EmployeeDaoFactory {
    public EmployeeDao getEmployeeDao(String databaseType) {
        if(databaseType == null) {
            return null;
        }
        switch (databaseType) {
            case "MSSQL":
                return new EmployeeDaoMsSQLImpl();
            case "MYSQL":
                return new EmployeeDaoMySQLImpl();
            case "ORACLE":
                return new EmployeeDaoOracleImpl();
        }
        return null;
    }
}
