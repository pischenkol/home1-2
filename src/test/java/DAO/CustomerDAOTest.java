package DAO;

import models.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.*;

/**
 * Created by appleface on 28.05.16.
 */
public class CustomerDAOTest {
    private static final java.lang.String DB_URL = "jdbc:mysql://localhost/test";
    private static final String USER = "root";
    private static final String PASS = "my-new-password";



    @Test
    public void testSave() throws Exception {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        CustomerDAO cust = new CustomerDAO(connection);


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
        CustomerDAO cust = new CustomerDAO(connection);

         Customer testCust = cust.getById(2101);
        String actual = testCust.getCompany();
        String expected = "Jones Mfg.";
        Assert.assertEquals(actual,expected);


    }

    @Test
    public void testGetAll() throws Exception {

    }

    @Test
    public void testGet2103() throws Exception {

    }
}