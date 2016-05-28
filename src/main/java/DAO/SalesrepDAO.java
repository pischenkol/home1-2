package DAO;

import models.Customer;
import models.Salesrep;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by appleface on 26.05.16.
 */
public class SalesrepDAO {
    private final Connection connection;

    public SalesrepDAO(Connection connection) {
        this.connection = connection;
    }


    public boolean save(Salesrep salesrep) {
        String sql = String.format("insert into SALESREPS(EMPL_NUM,NAME,AGE,REP_OFFICE,TITLE,HIRE_DATE,MANAGER,QUOTA,SALES) values(%d,'%s','%d',%d,'%s','%s',%d,'%d','%d,)",
                salesrep.getId(), salesrep.getName(), salesrep.getAge(), salesrep.getRepOffice(), salesrep.getTitle(), salesrep.getManager(), salesrep.getQuota(), salesrep.getSales());
        return executeSql(sql);
    }

    public boolean update(Salesrep salesrep) {
        String sql = String.format("update SALESREPS set NAME='%d',AGE='%d',REP_OFFICE='%d',TITLE='%d',HIRE_DATE='%d',MANAGER='%d',QUOTA='%d',SALES='%d' where EMPL_NUM=%s",
                salesrep.getName(), salesrep.getAge(), salesrep.getRepOffice(), salesrep.getTitle(), salesrep.getHireDate(), salesrep.getManager(), salesrep.getQuota(), salesrep.getSales(), salesrep.getId());
        return executeSql(sql);
    }

    public boolean delete(Salesrep salesrep) {
        String sql = String.format("delete from SALESREPS where EMPL_NUM=%s",
                salesrep.getId());
        return executeSql(sql);
    }

    public Salesrep getById(int id) {
        String sql = String.format("select * from SALESREPS where EMPL_NUM=%d",
                id);
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Salesrep salesrep = null;
            if (resultSet.next()) {
                salesrep = new Salesrep();
                salesrep.setId(resultSet.getInt("EMPL_NUM"));
                salesrep.setName(resultSet.getString("NAME"));
                salesrep.setAge(resultSet.getInt("AGE"));
                salesrep.setRepOffice(resultSet.getInt("REP_OFFICE"));
                salesrep.setTitle(resultSet.getString("TITLE"));
                salesrep.setHireDate(resultSet.getDate("HIRE_DATE"));
                salesrep.setManager(resultSet.getInt("MANAGER"));
                salesrep.setQuota(resultSet.getDouble("QUOTA"));
                salesrep.setSales(resultSet.getDouble("SALES"));
            }
            resultSet.close();
            return salesrep;
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

    public Set<Salesrep> getAll() {
        String sql = "select * from SALESREPS";
        Statement statement = null;
        Set<Salesrep> salesreps = new HashSet<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Salesrep salesrep = new Salesrep();
                salesrep.setId(resultSet.getInt("EMPL_NUM"));
                salesrep.setName(resultSet.getString("NAME"));
                salesrep.setAge(resultSet.getInt("AGE"));
                salesrep.setRepOffice(resultSet.getInt("REP_OFFICE"));
                salesrep.setTitle(resultSet.getString("TITLE"));
                salesrep.setHireDate(resultSet.getDate("HIRE_DATE"));
                salesrep.setManager(resultSet.getInt("MANAGER"));
                salesrep.setQuota(resultSet.getDouble("QUOTA"));
                salesrep.setSales(resultSet.getDouble("SALES"));
                salesreps.add(salesrep);
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
        return salesreps;
    }

    public Customer get2103() {
        String sql = String.format("select CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT from CUSTOMER where CUST_NUM=2103");
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

    public Set<Customer> getWhithCityAndRegion(){
        return null;
    }
    public Set<Customer> getWhithQuotaMoreOffice(){
        return null;
    }
    public Set<Customer> getWhithSalesMore350th(){
        return null;
    }
    public Set<Customer> getWhithNameCitySales(){
        return null;
    }
    public Set<Customer> getWhithOffice(){
        return null;
    }
    public Set<Customer> getWhithBoss(){
        return null;
    }
    public Set<Customer> getWhithSalesMoreBoss(){
        return null;
    }
    public Set<Customer> getWhithOfficeDiferentThanBoss(){
        return null;
    }
    public Set<Customer> getWhithSalesAndBirthday(){
        return null;
    }
    public Set<Customer> getWhithCitys(){
        return null;
    }
    public Set<Customer> getWhithCity(){
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
