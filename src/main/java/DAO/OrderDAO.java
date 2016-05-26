package DAO;

import models.Customer;
import models.Order;

import java.sql.Connection;
import java.util.Set;

/**
 * Created by appleface on 26.05.16.
 */
public class OrderDAO {
    private final Connection connection;

    public OrderDAO(Connection connection) {
        this.connection = connection;
    }
    public boolean save(Order audios){return true;}
    public boolean updete(Order audios){return true;}
    public boolean delede(Order audios){return true;}
    public Order getById(int id){
        return null;
    }
    public Set<Order> getAll(){
        return null;
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

}
