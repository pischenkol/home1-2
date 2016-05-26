package DAO;

import models.Customer;

import java.sql.Connection;
import java.util.Set;

/**
 * Created by appleface on 26.05.16.
 */
public class SalesrepDAO {
    private final Connection connection;

    public SalesrepDAO(Connection connection) {
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
}
