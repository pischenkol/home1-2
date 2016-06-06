package models;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

@Entity
@javax.persistence.Table(name = "OFFICES")
public class Office {
    private int id;
    private String city;
    private String region;
    private Manager manager;
    private double target;
    private double sales;
    private Set<Salesrep> salesrepSet = new HashSet<Salesrep>();

    public Set<Salesrep> getSalesrepSet() {
        return salesrepSet;
    }

    public void setSalesrepSet(Set<Salesrep> salesrepSet) {
        this.salesrepSet = salesrepSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }


    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }
}
