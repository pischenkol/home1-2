package DAO.DAOImpl;

import DAO.SpecialDao.ProductDao;
import models.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by appleface on 26.05.16.
 */
public class ProductDaoImpl implements ProductDao{

    private final Connection connection;

    public ProductDaoImpl(Connection connection) {
        this.connection = connection;
    }


    public boolean save(Product product) {
        String sql = String.format("insert into PRODUCTS(MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values(%d,'%s','%s')",
                product.getId(), product.getProductId(), product.getDescription(), product.getPrice(), product.getQtyOnHand());
        return executeSql(sql);
    }

    public boolean update(Product product) {
        String sql = String.format("update PRODUCTS set  PRODUCT_ID='%d', DESCRIPTION='%s',PRICE='%f', QTY_ON_HAND='%d' where MFR_ID=%d",
                product.getProductId(), product.getDescription(), product.getPrice(), product.getQtyOnHand(), product.getId());
        return executeSql(sql);
    }



    public boolean delete(Product product) {
        String sql = String.format("delete from PRODUCTS where MFR_ID=%d",
                product.getId());
        return executeSql(sql);
    }

    public Product getById(int id) {
        String sql = String.format("select * from PRODUCTS where MFR_ID=%d",
                id);
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Product product = null;
            if (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getString("MFR_ID"));
                product.setProductId(resultSet.getString("PRODUCT_ID"));
                product.setDescription(resultSet.getString("DESCRIPTION"));
                product.setPrice(resultSet.getFloat("PRICE"));
                product.setQtyOnHand(resultSet.getInt("QTY_ON_HAND"));

            }
            resultSet.close();
            return product;
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

    public Set<Product> getAll() {
        String sql = "select * from PRODUCTS";
        Statement statement = null;
        Set<Product> products = new HashSet<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getString("MFR_ID"));
                product.setProductId(resultSet.getString("PRODUCT_ID"));
                product.setDescription(resultSet.getString("DESCRIPTION"));
                product.setPrice(resultSet.getFloat("PRICE"));
                product.setQtyOnHand(resultSet.getInt("QTY_ON_HAND"));
                products.add(product);
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
        return products;
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
