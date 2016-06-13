package DAO.HibernateDaoImpl;

import DAO.SpecialDao.OfficeDao;
import models.Office;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class OfficeDaoHB implements OfficeDao{

    private final SessionHolder holder;

    OfficeDaoHB(SessionHolder holder) {
        this.holder = holder;
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

        try (Statement statement =holder.obtainConnection().createStatement()){
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
        }
        return null;
    }

    public List<Office> getAll() {
        String sql = "select OFFICE,CITY,REGION from OFFICES";

        List<Office> offices = new ArrayList<>();
        try (Statement statement =holder.obtainConnection().createStatement()){

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
        }
        return offices;
    }

    private boolean executeSql(String sql) {
        int count = 0;

        try(Statement statement =holder.obtainConnection().createStatement()) {

            count = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count == 1;
    }



}
