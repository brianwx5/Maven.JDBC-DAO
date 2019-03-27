package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static final String mySqlUser = "root";
    private static final String mySqlPwd = "Temp12345";
    private static final String mySqlServer = "jdbc:mysql://localhost:3306/carDB?autoReconnect=true&useSSL=false";

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(mySqlServer,mySqlUser,mySqlPwd);
        return conn;
    }

    public static void showErrorMessage(SQLException e){
        System.err.println("Error :" + e.getMessage());
        System.err.println("Error code: " + e.getErrorCode());
    }
}
