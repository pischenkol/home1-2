package DAO.DAOImpl;

import DAO.SpecialDao.CustomerDao;
import models.Customer;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by appleface on 26.05.16.
 */
public class CustomerDaoImpl implements CustomerDao{

    private final Connection connection;

    public CustomerDaoImpl(Connection connection) {
        this.connection = connection;
    }


    public boolean save(Customer customer) {
        String sql = String.format("insert into CUSTOMERS (COMPANY,CUST_REP,CREDIT_LIMIT) values(%s,'%s','%d')",
                customer.getCompany(), customer.getCustRep(), customer.getCreditLimit());
        return executeSql(sql);
    }

    public boolean update(Customer customer) {
        String sql = String.format("update CUSTOMERS set COMPANY='%s', CUST_REP='%s' CREDIT_LIMIT='%d' where CUST_NUM=%s",
                customer.getCompany(), customer.getCustRep(), customer.getCreditLimit(), customer.getId());
        return executeSql(sql);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    public boolean delete(Customer customer) {
        String sql = String.format("delete from CUSTOMERS where CUST_NUM=%s",
                customer.getId());
        return executeSql(sql);
    }

    public Customer getById(int id) {
        String sql = String.format("select CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT from CUSTOMERS where CUST_NUM=%d",
                id);
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Customer customer = null;
            if (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getInt("CUST_NUM"));
                customer.setCompany(resultSet.getString("COMPANY"));
                customer.setCustRep(resultSet.getInt("CUST_REP"));
                customer.setCreditLimit(resultSet.getDouble("CREDIT_LIMIT"));
            }
            resultSet.close();
            return customer;
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
        return null;
    }

    public Set<Customer> getAll() {
        String sql = "select * from CUSTOMERS";
        Statement statement = null;
       Set<Customer> customers = new HashSet<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("CUST_NUM"));
                customer.setCompany(resultSet.getString("COMPANY"));
                customer.setCustRep(resultSet.getInt("CUST_REP"));
                customer.setCreditLimit(resultSet.getDouble("CREDIT_LIMIT"));
                customers.add(customer);
            }
            resultSet.close();
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
        return customers;
    }
    public Customer get2103() {
        String sql = String.format("select CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT from CUSTOMERS where CUST_NUM=2103");
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Customer customer = null;
            if (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getInt("CUST_NUM"));
                customer.setCompany(resultSet.getString("COMPANY"));
                customer.setCustRep(resultSet.getInt("CUST_REP"));
                customer.setCreditLimit(resultSet.getDouble("CREDIT_LIMIT"));
            }
            resultSet.close();
            return customer;
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
