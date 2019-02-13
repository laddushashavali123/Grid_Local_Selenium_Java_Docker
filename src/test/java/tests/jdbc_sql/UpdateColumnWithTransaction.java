package tests.jdbc_sql;

import utils.database.MySQLConnUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class UpdateColumnWithTransaction {
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
            /**
             * Set no SQL statements are committed until the method commit is called. All statements executed after the
             * previous call to the method commit are included in the current transaction and committed together as a
             * unit.
             */
            con.setAutoCommit(false);

            updateSales = con.prepareStatement(updateString);
            updateTotal = con.prepareStatement(updateStatement);

            for (Map.Entry<String, Integer> e : data.entrySet()) {
                updateSales.setInt(1, e.getValue().intValue());
                updateSales.setString(2, e.getKey());
                int x = updateSales.executeUpdate();
                System.out.println(x);
                updateTotal.setInt(1, e.getValue().intValue());
                updateTotal.setString(2, e.getKey());
                // Executing PreparedStatement Objects
                int y = updateTotal.executeUpdate();
                System.out.println(y);
                /**
                 * Two prepared statements updateSales and updateTotal are committed together when the method commit is
                 * called.
                 */
                con.commit();
            }
        } catch (SQLException e ) {
            e.printStackTrace();
            if (con != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    con.rollback();
                } catch(SQLException excep) {
                    excep.printStackTrace();
                }
            }
        } finally {
            if (updateSales != null) {
                updateSales.close();
            }
            if (updateTotal != null) {
                updateTotal.close();
            }
            /**
             * Enable auto-commit mode, which means that each statement is once again committed automatically when it is completed.
             */
            con.setAutoCommit(true);
        }
    }
}
