package DAO;

import models.Customer;
import models.Order;
import models.Product;
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
                order.getId(), order.getOrderDate(), order.getCast(), order.getRep(), order.getMfr(), order.getProduct(), order.getQty(), order.getAmount());
        return executeSql(sql);
    }

    public boolean update(Order order) {
        String sql = String.format("update ORDERS set ORDER_DATE='%d',CUST,REP='%d',MFR='%s', PRODUCT='%s',QTY='%d', AMOUNT='%f' where ORDER_NUM=%d",
                order.getOrderDate(), order.getCast(), order.getRep(), order.getMfr(), order.getProduct(), order.getQty(), order.getAmount(), order.getId());
        return executeSql(sql);
    }

    public boolean delete(Order order) {
        String sql = String.format("delete from ORDERS where ORDER_NUM=%d",
                order.getId());
        return executeSql(sql);
    }

    public Order getById(int id) {
        String sql = String.format("select ORDER_DATE,CUST,REP,MFR, PRODUCT,QTY, AMOUNT from ORDERS where ORDER_NUM=%d",
                id);
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Order order = null;
            if (resultSet.next()) {
                order = new Order();
                order.setId(resultSet.getInt("ORDER_NUM"));
                order.setOrderDate(resultSet.getDate("ORDER_DATE"));
                order.setCast(resultSet.getInt("CUST"));
                order.setMfr(resultSet.getString("MFR"));
                order.setProduct(resultSet.getString("PRODUCT"));
                order.setQty(resultSet.getInt("QTY"));
                order.setAmount(resultSet.getFloat("AMOUNT"));

            }
            resultSet.close();
            return order;
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
        String sql = "select * from OFFICES";
        Statement statement = null;
        Set<Order> orders = new HashSet<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("ORDER_NUM"));
                order.setOrderDate(resultSet.getDate("ORDER_DATE"));
                order.setCast(resultSet.getInt("CUST"));
                order.setMfr(resultSet.getString("MFR"));
                order.setProduct(resultSet.getString("PRODUCT"));
                order.setQty(resultSet.getInt("QTY"));
                order.setAmount(resultSet.getFloat("AMOUNT"));
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
        return orders;
    }


    public Set<Order> getWhithCustomer() {
        String sql = "SELECT ORDER_NUM ,  AMOUNT, COMPANY, CREDIT_LIMIT FROM ORDERS ,CUSTOMERS WHERE CUST=CUST_NUM";
        Statement statement = null;
        Set<Order> orders = new HashSet<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Order order = new Order();
                Customer customer = new Customer();
                order.setId(resultSet.getInt("ORDER_NUM"));
                order.setAmount(resultSet.getFloat("AMOUNT"));
                customer.setCompany(resultSet.getString("COMPANY"));
                customer.setCreditLimit(resultSet.getDouble("CREDIT_LIMIT"));
                order.getCustomers().add(customer);
                orders.add(order);

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
        return orders;

    }

    public Set<Order> getWhithDescription() {
        String sql = "SELECT ORDER_NUM , AМOUNT, DESCRIPTION FROM ORDERS JOIN PRODUCTS ON MFR = MFR_ID AND PRODUCT = PRODUCT_ID";
        Statement statement = null;
        Set<Order> orders = new HashSet<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Order order = new Order();
                Product product = new Product();
                order.setId(resultSet.getInt("ORDER_NUM"));
                order.setAmount(resultSet.getFloat("AMOUNT"));
                product.setDescription(resultSet.getNString("DESCRIPTION"));
                order.getProducts().add(product);


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
        return orders;
    }

    public Set<Order> getMore25thWhithCustAndRep() {
        String sql = "SELECT ORDER_NUM,  AMOUNT, COMPANY , NAMЕ FROM ORDERS , CUSTOMERS , SALESREPS  WHERE CUST = CUST_NUM AND CUST_REP = EMPL_NUM    AND AMОUNT > 25000.00";
        Statement statement = null;
        Set<Order> orders = new HashSet<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Order order = new Order();
                Salesrep salesrep = new Salesrep();
                Customer customer = new Customer();
                order.setId(resultSet.getInt("ORDER_NUM"));
                order.setAmount(resultSet.getFloat("AMOUNT"));
                salesrep.setName(resultSet.getString("NAMЕ"));
                customer.setCompany(resultSet.getNString("COMPANY"));
                order.getSalesreps().add(salesrep);
                order.getCustomers().add(customer);
                orders.add(order);


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
        return orders;
    }


    public Set<Order> getWithNewSalesrep() {
        String sql = "SELECT  ORDER_NUM, AMOUNT, ORDER_DATE , NAMЕ FROM ORDERS, SALESREPS WHERE ORDER_DATE = HIRE_DATE";
        Statement statement = null;
        Set<Order> orders = new HashSet<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Order order = new Order();
                Salesrep salesrep = new Salesrep();
                order.setId(resultSet.getInt("ORDER_NUM"));
                order.setAmount(resultSet.getFloat("AMOUNT"));
                order.setOrderDate(resultSet.getDate("ORDER_DATE"));
                salesrep.setName(resultSet.getString("NAMЕ"));
                order.getSalesreps().add(salesrep);
                orders.add(order);

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
        return orders;
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
