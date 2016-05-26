package DAO;

import models.Customer;

import java.sql.Connection;
import java.util.Set;

/**
 * Created by appleface on 26.05.16.
 */
public class OfficeDAO {
    private final Connection connection;

    public OfficeDAO(Connection connection) {
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
    public Set<Customer> getWhithBoss(){
        return null;
    }
    public Set<Customer> getWhithMgr600(){
        return null;
    }
}
