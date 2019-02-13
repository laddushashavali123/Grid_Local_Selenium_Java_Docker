package tests.jdbc_sql;

import utils.database.MySQLConnUtils;

import java.sql.*;


public class CreateTableWithStatement {
    public static void main(String[] args) throws SQLException {
        String hostName = "localhost";
        String dbName   = "HelloController";
        String userName = "root";
        String password = "root";

        System.out.println("Try to connect to " + dbName + " database on " + hostName + " ...");
        Connection conn = MySQLConnUtils.getMySQLConnection(hostName, dbName, userName, password);
        System.out.println(conn.getCatalog() + " is connected !!!");

        // SQL query
        String createSuppliersTable = "create table " + dbName + ".SUPPLIERS " + "(SUP_ID integer NOT NULL, "
                + "SUP_NAME varchar(40) NOT NULL, " + "STREET varchar(40) NOT NULL, " + "CITY varchar(20) NOT NULL, "
                + "STATE char(2) NOT NULL, " + "ZIP char(5), " + "PRIMARY KEY (SUP_ID))";
        String createCoffeesTable = "create table " + dbName + ".COFFEES " + "(COF_NAME varchar(32) NOT NULL, "
                + "SUP_ID int NOT NULL, " + "PRICE float NOT NULL, " + "SALES integer NOT NULL, "
                + "TOTAL integer NOT NULL, " + "PRIMARY KEY (COF_NAME), " + "FOREIGN KEY (SUP_ID) REFERENCES "
                + dbName + ".SUPPLIERS (SUP_ID))";
        String supplierEntry1 = "insert into " + dbName + ".SUPPLIERS " + "values(49, 'Superior Coffee', "
                + "'1 Party Place', " + "'Mendocino', 'CA', '95460')";
        String supplierEntry2 = "insert into " + dbName + ".SUPPLIERS " + "values(101, 'Acme, Inc.', "
                + "'99 Market Street', " + "'Groundsville', 'CA', '95199')";
        String supplierEntry3 = "insert into " + dbName + ".SUPPLIERS " + "values(150, " + "'The High Ground', "
                + "'100 Coffee Lane', " + "'Meadows', 'CA', '93966')";
        String coffeeEntry1 = "insert into " + dbName + ".COFFEES " + "values('Colombian', 00101, " + "7.99, 0, 0)";
        String coffeeEntry2 = "insert into " + dbName + ".COFFEES " + "values('French_Roast', " + "00049, 8.99, 0, 0)";
        String coffeeEntry3 = "insert into " + dbName + ".COFFEES " + "values('Espresso', 00150, 9.99, 0, 0)";
        String coffeeEntry4 = "insert into " + dbName + ".COFFEES " + "values('Colombian_Decaf', " + "00101, 8.99, 0, 0)";
        String coffeeEntry5 = "insert into " + dbName + ".COFFEES " + "values('French_Roast_Decaf', " + "00049, 9.99, 0, 0)";

                // Command
        MySQLConnUtils.sendSqlViaStatement(conn, createSuppliersTable);
        MySQLConnUtils.sendSqlViaStatement(conn, createCoffeesTable);
        MySQLConnUtils.sendSqlViaStatement(conn, supplierEntry1);
        MySQLConnUtils.sendSqlViaStatement(conn, supplierEntry2);
        MySQLConnUtils.sendSqlViaStatement(conn, supplierEntry3);
        MySQLConnUtils.sendSqlViaStatement(conn, coffeeEntry1);
        MySQLConnUtils.sendSqlViaStatement(conn, coffeeEntry2);
        MySQLConnUtils.sendSqlViaStatement(conn, coffeeEntry3);
        MySQLConnUtils.sendSqlViaStatement(conn, coffeeEntry4);
        MySQLConnUtils.sendSqlViaStatement(conn, coffeeEntry5);

    }
}
