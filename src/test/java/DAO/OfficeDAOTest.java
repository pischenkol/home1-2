package DAO;

import DAO.JdbcDaoImpl.OfficeDaoJdbc;
import DAO.SpecialDao.OfficeDao;
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
        OfficeDao officeDAO = new OfficeDaoJdbc(getConnection());
        Office testCust = officeDAO.getById(11);
        String actual = testCust.getCity();
        String expected = "New York";
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testGetAll() throws Exception {


    }
}