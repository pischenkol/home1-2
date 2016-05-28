package models;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by appleface on 26.05.16.
 */
public class Office {
    private int id;
    private String city;
    private String region;
    private int mgr;
    private double target;
    private double sales;
    private Set<Salesrep> salesrepSet = new HashSet<>();

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

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
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
