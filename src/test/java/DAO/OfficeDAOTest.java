package DAO;

import models.Customer;
import models.Office;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by appleface on 28.05.16.
 */
public class OfficeDAOTest {
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
        OfficeDAO officeDAO = new OfficeDAO(connection);

        Office testCust = officeDAO.getById(11);
        String actual = testCust.getCity();
        String expected = "New York";
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testGetAll() throws Exception {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        OfficeDAO office = new OfficeDAO(connection);
        Set<Office> offices = new HashSet<>();
        offices.addAll(office.getAll());
        int actual  = offices.size();
        int expected = 5;
        Assert.assertEquals(expected,actual);


    }

    @Test
    public void testGetWhithBoss() throws Exception {

    }

    @Test
    public void testGetWhithMgr600() throws Exception {

    }

    @Test
    public void testGetCityWhithSalesMoreTarget() throws Exception {

    }
}