package DAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by appleface on 26.05.16.
 */
public class ConnectionJDBS {
    private String url = "jdbc:mysql://192.168.33.10:3306/test";
    private String login = "root";
    private String password  = "my-new-password";
    public Connection getConnection() {


        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, login, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return connection;
    }
}
