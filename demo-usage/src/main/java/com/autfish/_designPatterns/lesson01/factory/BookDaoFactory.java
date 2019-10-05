package com.autfish._designPatterns.lesson01.factory;

public class BookDaoFactory {
    public BookDao getBookDao(String databaseType) {
        if(databaseType == null) {
            return null;
        }
        switch (databaseType) {
            case "MSSQL":
                return new MSSqlBookDao();
            case "MYDQL":
                return new MySQLBookDao();
            case "ORACLE":
                return new OracleBookDao();
        }
        return null;
    }
}
