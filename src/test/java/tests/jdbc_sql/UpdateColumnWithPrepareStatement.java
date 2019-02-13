package tests.jdbc_sql;

import utils.database.MySQLConnUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class UpdateColumnWithPrepareStatement {
    public static void main(String[] args) throws SQLException {
        String hostName = "localhost";
        String dbName   = "HelloController";
        String userName = "root";
        String password = "root";

        System.out.println("Try to connect to " + dbName + " database on " + hostName + " ...");
        Connection con = MySQLConnUtils.getMySQLConnection(hostName, dbName, userName, password);
        System.out.println(con.getCatalog() + " is connected !!!");

        // Data
        HashMap<String, Integer> salesForWeek = new HashMap<>();
        salesForWeek.put("French_Roast", 100);
        salesForWeek.put("Espresso", 20);


        // SQL query
        updateCoffeeSales(con, "HelloController", salesForWeek);

    }

    public static void updateCoffeeSales(Connection con, String dbName, HashMap<String, Integer> data) throws SQLException {

        PreparedStatement updateSales = null;
        PreparedStatement updateTotal = null;

        String updateString    = "update " + dbName + ".COFFEES set SALES = ? where COF_NAME = ?";
        String updateStatement = "update " + dbName + ".COFFEES set TOTAL = TOTAL + ? where COF_NAME = ?";

        try {
            // Creating a PreparedStatement Object
            updateSales = con.prepareStatement(updateString);
            updateTotal = con.prepareStatement(updateStatement);

            for (Map.Entry<String, Integer> e : data.entrySet()) {
                /**
                 * Supplying Values for PreparedStatement Parameters
                 *  You must supply values in place of the question mark placeholders (if there are any) before you can
                 *  execute a PreparedStatement object by calling setter methods:
                 *      The first argument specifies the question mark placeholder location.
                 *      The second argument specifies the value for question mark
                 */
                updateSales.setInt(1, e.getValue().intValue());     // replace first ? with value
                updateSales.setString(2, e.getKey());               // replace second ? with value
                int x = updateSales.executeUpdate();                             // send SQL query and return number of affect row
                updateTotal.setInt(1, e.getValue().intValue());
                updateTotal.setString(2, e.getKey());
                int y = updateTotal.executeUpdate();
                System.out.println(y);
            }
        } catch (SQLException e ) {
            e.printStackTrace();
            if (con != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    con.rollback();
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            if (updateSales != null) {
                updateSales.close();
            }
            if (updateTotal != null) {
                updateTotal.close();
            }
        }
    }
}
