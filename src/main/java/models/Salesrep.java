package models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by appleface on 26.05.16.
 */
public class Salesrep {
    private int id;
    private String name;
    private int age;
    private int repOffice;
    private String title;
    private Date hireDate;
    private int manager;
    private double quota;
    private double sales;
    private Set<Salesrep> salesreps= new HashSet<>();
    private Set<Office> offices = new HashSet<>();

    public Set<Salesrep> getSalesreps() {
        return salesreps;
    }

    public void setSalesreps(Set<Salesrep> salesreps) {
        this.salesreps = salesreps;
    }

    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRepOffice() {
        return repOffice;
    }

    public void setRepOffice(int repOffice) {
        this.repOffice = repOffice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public double getQuota() {
        return quota;
    }

    public void setQuota(double quota) {
        this.quota = quota;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }
}
