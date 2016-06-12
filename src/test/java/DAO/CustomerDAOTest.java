package DAO;

import DAO.DAOImpl.CustomerDaoImpl;
import models.Customer;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by appleface on 28.05.16.
 */
public class CustomerDAOTest {
    private static final java.lang.String DB_URL = "jdbc:mysql://192.168.33.10/test";
    private static final String USER = "root";
    private static final String PASS = "my-new-password";



    @Test
    public void testSave() throws Exception {



    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testGetById() throws Exception {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        CustomerDaoImpl cust = new CustomerDaoImpl(connection);

        Customer testCust = cust.getById(2101);
        String actual = testCust.getCompany();
        String expected = "Jones Mfg.";
        Assert.assertEquals(expected,actual);


    }

    @Test
    public void testGetAll() throws Exception {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        CustomerDaoImpl cust = new CustomerDaoImpl(connection);
        Set<Customer> customers = new HashSet<>();
        customers.addAll(cust.getAll());
        int actual  =customers.size();
        int expected = 24;
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testGet2103() throws Exception {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        CustomerDaoImpl cust = new CustomerDaoImpl(connection);

        Customer testCust = cust.get2103();
        String actual = testCust.getCompany();
        String expected = "Acme Mfg.";
        Assert.assertEquals(expected,actual);

    }
}