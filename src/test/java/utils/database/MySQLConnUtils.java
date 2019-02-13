package utils.database;

import java.sql.*;

public class MySQLConnUtils {
    // Kết nối vào MySQL
    public static Connection getMySQLConnection() throws SQLException {
        String hostName = "localhost";
        String dbName   = "myblog";
        String userName = "root";
        String password = "root";

        return getMySQLConnection(hostName, dbName, userName, password);
    }

    // Kết nối vào MySQL
    public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws SQLException {
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?useSSL=false";
        Connection con = DriverManager.getConnection(connectionURL, userName, password);
        return con;
    }

    public static void sendSqlViaStatement(Connection con, String sqlQuery) throws SQLException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) { stmt.close(); }
        }
    }
}
