package DAO;

import DAO.DAOImpl.OfficeDaoImpl;
import DAO.DAOImpl.SessionHolder;
import models.Office;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by appleface on 28.05.16.
 */
public class OfficeDAOTest {
    @Before
    public Connection getConnection(){
         String url = "jdbc:mysql://192.168.33.10/test";
         String user = "root";
        String password = "my-new-password";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }


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
//        OfficeDaoImpl officeDAO = new OfficeDaoImpl( new SessionHolder());
//
//
//        Office testCust = officeDAO.getById(11);
//        String actual = testCust.getCity();
//        String expected = "New York";
//        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testGetAll() throws Exception {

//        OfficeDaoImpl office = new OfficeDaoImpl(getConnection());
//        Set<Office> offices = new HashSet<>();
//        offices.addAll(office.getAll());
//        int actual  = offices.size();
//        int expected = 5;
//        Assert.assertEquals(expected,actual);


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