package DAO.DAOImpl;

import DAO.SpecialDao.SalesrepDao;
import models.Office;
import models.Salesrep;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by appleface on 26.05.16.
 */
public class SalesrepDaoImpl implements SalesrepDao{
    private final Connection connection;

    public SalesrepDaoImpl(Connection connection) {
        this.connection = connection;
    }


    public boolean save(Salesrep salesrep) {
        String sql = String.format("insert into SALESREPS(EMPL_NUM,NAME,AGE,REP_OFFICE,TITLE,HIRE_DATE,MANAGER,QUOTA,SALES) values(%d,'%s','%d',%d,'%s','%s',%d,'%d','%d,)",
                salesrep.getId(), salesrep.getName(), salesrep.getAge(), salesrep.getRepOffice(), salesrep.getTitle(), salesrep.getManager(), salesrep.getQuota(), salesrep.getSales());
        return executeSql(sql);
    }

    public boolean update(Salesrep salesrep) {
        String sql = String.format("update SALESREPS set NAME='%d',AGE='%d',REP_OFFICE='%d',TITLE='%d',HIRE_DATE='%d',MANAGER='%d',QUOTA='%d',SALES='%d' where EMPL_NUM=%s",
                salesrep.getName(), salesrep.getAge(), salesrep.getRepOffice(), salesrep.getTitle(), salesrep.getHireDate(), salesrep.getManager(), salesrep.getQuota(), salesrep.getSales(), salesrep.getId());
        return executeSql(sql);
    }

    @Override
    public boolean delete(Salesrep id) {
        return false;
    }


    public Salesrep getById(int id) {
        String sql = String.format("select * from SALESREPS where EMPL_NUM=%d",
                id);
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Salesrep salesrep = null;
            if (resultSet.next()) {
                salesrep = new Salesrep();
                salesrep.setId(resultSet.getInt("EMPL_NUM"));
                salesrep.setName(resultSet.getString("NAME"));
                salesrep.setAge(resultSet.getInt("AGE"));
                salesrep.setRepOffice(resultSet.getInt("REP_OFFICE"));
                salesrep.setTitle(resultSet.getString("TITLE"));
                salesrep.setHireDate(resultSet.getDate("HIRE_DATE"));
                salesrep.setQuota(resultSet.getDouble("QUOTA"));
                salesrep.setSales(resultSet.getDouble("SALES"));
            }
            resultSet.close();
            return salesrep;
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

    public Set<Salesrep> getAll() {
        String sql = "select * from SALESREPS";
        Statement statement = null;
        Set<Salesrep> salesreps = new HashSet<Salesrep>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Salesrep salesrep = new Salesrep();
                salesrep.setId(resultSet.getInt("EMPL_NUM"));
                salesrep.setName(resultSet.getString("NAME"));
                salesrep.setAge(resultSet.getInt("AGE"));
                salesrep.setRepOffice(resultSet.getInt("REP_OFFICE"));
                salesrep.setTitle(resultSet.getString("TITLE"));
                salesrep.setHireDate(resultSet.getDate("HIRE_DATE"));
                salesrep.setQuota(resultSet.getDouble("QUOTA"));
                salesrep.setSales(resultSet.getDouble("SALES"));
                salesreps.add(salesrep);
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
        return salesreps;
    }


    public Set<Salesrep> getWhithCityAndRegion(){
        String sql = "SELECT NAMЕ , CITY , REGION FROM SALESREPS , OFFICES WHERE REP_OFFICE = OFFICE";
        Statement statement = null;
        Set<Salesrep> salesreps = new HashSet<Salesrep>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Salesrep salesrep = new Salesrep();
                Office office = new Office();
                salesrep.setName(resultSet.getString("NAME"));
                office.setCity(resultSet.getString("CITY"));
                office.setRegion(resultSet.getString("REGION"));
                salesrep.getOffices().add(office);
                salesreps.add(salesrep);
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
        return salesreps;
    }
    public Set<Salesrep> getWhithQuotaMoreOffice(){
        String sql = "SELECT NAMЕ, QUOTA, CITY, TARGET FROM  SALESREPS , OFFICES WHERE QUOTA > TARGET";
        Statement statement = null;
        Set<Salesrep> salesreps = new HashSet<Salesrep>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Salesrep salesrep = new Salesrep();
                Office office = new Office();
                salesrep.setName(resultSet.getString("NAME"));
                salesrep.setTitle(resultSet.getString("TITLE"));
                office.setCity(resultSet.getString("CITY"));
                salesrep.getOffices().add(office);
                salesreps.add(salesrep);
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
        return salesreps;
    }
    public Set<Salesrep> getWhithSalesMore350th(){
        String sql = "SELECT NАМЕ , SALES FROM SALESREPS WHERE SALES > 350000.00";
        Statement statement = null;
        Set<Salesrep> salesreps = new HashSet<Salesrep>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Salesrep salesrep = new Salesrep();
                salesrep.setName(resultSet.getString("NAME"));
                salesrep.setSales(resultSet.getDouble("SALES"));

                salesreps.add(salesrep);
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
        return salesreps;
    }
    public Set<Salesrep> getWhithNameCitySales(){
        String sql = "SELECT NAMЕ, CITY, SALES FROM  SALESREPS , OFFICES ";
        Statement statement = null;
        Set<Salesrep> salesreps = new HashSet<Salesrep>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Salesrep salesrep = new Salesrep();
                Office office = new Office();
                salesrep.setName(resultSet.getString("NAME"));
                office.setCity(resultSet.getString("CITY"));
                salesrep.getOffices().add(office);
                salesreps.add(salesrep);
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
        return salesreps;
    }
    public Set<Salesrep> getWhithOffice(){
        String sql = "SELECT SALESREPS . * , CITY , REGION FROM SALESREPS, OFFICES WНERE REP_OFFICE = OFFICE";
        Statement statement = null;
        Set<Salesrep> salesreps = new HashSet<Salesrep>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Salesrep salesrep = new Salesrep();
                Office office = new Office();
                salesrep.setName(resultSet.getString("NAME"));
                office.setCity(resultSet.getString("CITY"));
                office.setRegion(resultSet.getString("REGION"));
                salesrep.getOffices().add(office);
                salesreps.add(salesrep);
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
        return salesreps;
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
