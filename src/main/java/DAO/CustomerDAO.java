package DAO;

import models.Customer;

import java.sql.*;
import java.util.Set;


/**
 * Created by appleface on 26.05.16.
 */
public class CustomerDAO {
    public final String url = "jdbc:mysql://192.168.33.10:3306/test";
    public final String login = "root";
    public final String password = "my-new-password";

    public boolean save(Customer customer) {
        Boolean bl = false;
        try (Connection connection = DriverManager.getConnection(url,login,password)) {
            Statement st = connection.createStatement();
            bl = st.execute("insert into CUSTOMERS(COMPANY, CUST_REP, CREDIT_LIMIT) values(%s,'%i','%d')");
            return bl;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return bl;
    }

    public boolean update(Customer customer) {
        int bl = 0;
        try (Connection connection = DriverManager.getConnection(url,login,password)) {
            Statement st = connection.createStatement();
            bl = st.executeUpdate("insert into CUSTOMERS(COMPANY, CUST_REP, CREDIT_LIMIT) values(%s,'%i','%d')");
            return bl!=0;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    public boolean delete(Customer customer) {
        return true;
    }

    public Customer getById(int id) {
        return null;
    }

    public Set<Customer> getAll() {
        return null;
    }

    public Set<Customer> get2103() {
        return null;
    }


    private boolean executeSql(String sql) {
        int count = 0;
        Statement statement = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,login,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
            count = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return count == 1;
    }
}
