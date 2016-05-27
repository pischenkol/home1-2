package DAO;

import models.Customer;
import models.Office;
import models.Order;
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
public class OrderDAO {
    private final Connection connection;

    public OrderDAO(Connection connection) {
        this.connection = connection;
    }


    public boolean save(Order order) {
        String sql = String.format("insert into ORDERS(ORDER_NUM,ORDER_DATE,CUST,REP,MFR, PRODUCT,QTY, AMOUNT ) values(%s,'%s','%d','%d','%s','%s','%d','%f')",
                order.getId(), order.getOrderDate(), order.getCast(), order.getRep(), order.getMfr(), order.getProduct(), order.getQty(),order.getAmount());
        return executeSql(sql);
    }

    public boolean update(Order order) {
        String sql = String.format("update ORDERS set ORDER_DATE='%d',CUST,REP='%d',MFR='%s', PRODUCT='%s',QTY='%d', AMOUNT='%f' where ORDER_NUM=%d",
                order.getOrderDate(), order.getCast(), order.getRep(), order.getMfr(), order.getProduct(), order.getQty(),order.getAmount(), order.getId());
        return executeSql(sql);
    }

    public boolean delete(Order order) {
        String sql = String.format("delete from OFFICES where OFFICE=%s",
                office.getId());
        return executeSql(sql);
    }

    public Office getById(int id) {
        String sql = String.format("select OFFICE,CITY,REGION from OFFICES where OFFICE=%d",
                id);
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Office office = null;
            if (resultSet.next()) {
                office = new Office();
                office.setId(resultSet.getInt("OFFICE"));
                office.setCity(resultSet.getString("CITY"));
                office.setRegion(resultSet.getString("REGION"));
            }
            resultSet.close();
            return office;
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

    public Set<Order> getAll() {
        String sql = "select OFFICE,CITY,REGION from OFFICES";
        Statement statement = null;
        Set<Office> offices = new HashSet<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Office office = new Office();
                office.setId(resultSet.getInt("OFFICE"));
                office.setCity(resultSet.getString("CITY"));
                office.setRegion(resultSet.getString("REGION"));
                offices.add(office);
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
        return offices;
    }


    public Set<Order> getWhithCustomer(){
        return null;
    }
    public Set<Order> getWhithDescription(){
        return null;
    }
    public Set<Order> getMore25thWhithCustAndRep(){
        return null;
    }
    public Set<Order> getMore25thWhithCustAndCustRep(){
        return null;
    }
    public Set<Order> getWithNewSalesrep(){
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
