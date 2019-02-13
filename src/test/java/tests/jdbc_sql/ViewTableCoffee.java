package tests.jdbc_sql;

import utils.database.MySQLConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewTableCoffee {
    public static void main(String[] args) throws SQLException {
        String hostName = "localhost";
        String dbName = "HelloController";
        String userName = "root";
        String password = "root";

        System.out.println("Try to connect to " + dbName + " database on " + hostName + " ...");
        Connection conn = MySQLConnUtils.getMySQLConnection(hostName, dbName, userName, password);
        System.out.println(conn.getCatalog() + " is connected !!!");

        Statement stmt = null;
        String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from " + dbName + ".COFFEES";

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("coffeeName\tsupplierID\tprice\tsales\ttotal");
            System.out.println("---------------------------------");
            while (rs.next()) {
                String coffeeName = rs.getString("COF_NAME");
                int supplierID = rs.getInt("SUP_ID");
                float price = rs.getFloat("PRICE");
                int sales = rs.getInt("SALES");
                int total = rs.getInt("TOTAL");
                System.out.println(coffeeName + "\t" + supplierID + "\t" + price + "\t" + sales + "\t" + total);
            }
        } catch (SQLException e ) {
            e.printStackTrace();
        } finally {
            if (stmt != null) { stmt.close(); }
        }
    }
}
