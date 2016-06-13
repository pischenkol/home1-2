package DAO.JdbcDaoImpl;

import DAO.SpecialDao.OfficeDao;
import com.mysql.jdbc.Connection;
import models.Office;
import models.Salesrep;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class OfficeDaoJdbc implements OfficeDao{
 java.sql.Connection connection = null;


    public OfficeDaoJdbc(java.sql.Connection connection) {
        this.connection = connection;
    }

    public boolean save(Office office) {
        String sql = String.format("insert into OFFICES(OFFICE,CITY,REGION) values(%d,'%s','%s')",
                office.getId(), office.getCity(), office.getRegion());
        return executeSql(sql);
    }

    public boolean update(Office office) {
        String sql = String.format("update OFFICES set CITY='%s', REGION='%s' where OFFICE=%d",
                office.getCity(), office.getRegion(), office.getId());
        return executeSql(sql);
    }



    public boolean delete(Office office) {
        String sql = String.format("delete from OFFICES where OFFICE=%s",
                office.getId());
        return executeSql(sql);
    }

    public Office getById(int id) {
        String sql = String.format("select OFFICE,CITY,REGION from OFFICES where OFFICE=%d",
                id);
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Office office = null;
            if (resultSet.next()) {
                office = new Office();
                office.setId(resultSet.getInt("OFFICE"));
                office.setCity(resultSet.getString("CITY"));
                office.setRegion(resultSet.getString("REGION"));
            }
            resultSet.close();
            return office;
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

    public Set<Office> getAll() {
        String sql = "select OFFICE,CITY,REGION from OFFICES";
        Statement statement = null;
        Set<Office> offices = new HashSet<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Office office = new Office();
                office.setId(resultSet.getInt("OFFICE"));
                office.setCity(resultSet.getString("CITY"));
                office.setRegion(resultSet.getString("REGION"));
                offices.add(office);
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
        return offices;
    }


    public Set<Office> getWhithBoss() {
        String sql = "SELECT CITY, NAME, TITLE FROM OFFICES , SALESREPS WHERE MGR = EMPL_NUL";
        Statement statement = null;
        Set<Office> offices = new HashSet<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Office office = new Office();
                Salesrep salesrep = new Salesrep();

                office.setCity(resultSet.getString("CITY"));
                salesrep.setName(resultSet.getString("NAME"));
                office.setId(resultSet.getInt("TITLE"));
                offices.add(office);
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
        return offices;

    }

    public Set<Office> getWhithMgr600() {
        String sql = "SELECT CITY, NАМЕ, TITLE FROM OFFICES JOIN SALESREPS ON MGR = EMPL NUМ WНERE TARGET > 600000.00";
        Statement statement = null;
        Set<Office> offices = new HashSet<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Office office = new Office();
                Salesrep salesrep = new Salesrep();

                office.setCity(resultSet.getString("CITY"));
                salesrep.setName(resultSet.getString("NAME"));
                office.setId(resultSet.getInt("TITLE"));


                offices.add(office);
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
        return offices;
    }

    public Set<Office> getCityWhithSalesMoreTarget() {
        String sql = "SELECT CITY , SALES FROM OFFICES WHERE SALES > TARGET";
        Statement statement = null;
        Set<Office> offices = new HashSet<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Office office = new Office();
                office.setCity(resultSet.getString("CITY"));

                offices.add(office);
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
        return offices;

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
