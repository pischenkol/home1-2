package DAO;

import models.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

/**
 * Created by appleface on 26.05.16.
 */
public class CustomerDAO {
    private final Connection connection;

    public CustomerDAO(Connection connection) {
        this.connection = connection;
    }
    public boolean save(Customer audios){return true;}
    public boolean updete(Customer audios){return true;}
    public boolean delede(Customer audios){return true;}
    public Customer getById(int id){
        return null;
    }
    public Set<Customer> getAll(){
        return null;
    }


    public Set<Customer> getByYearPlusAuthors(int year){
        return null;
    }
    public Set<Customer> getAudiosTheOldestAuthor(){
        return null;
    }

    private boolean executeSql(String sql) {
        int count = 0;
        Statement statement = null;
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
