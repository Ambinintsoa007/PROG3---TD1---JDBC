package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    String url = "jdbc:postgresql://localhost:5432/product_management_db";
    String user = "product_manager_user";
    String password = "123456";

    /*
    public Connection getDBConnection() {
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException err) {
            err.printStackTrace();
            return null;
        }
    }
    * */
    public Connection getDBConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
