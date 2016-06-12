package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@javax.persistence.Table(name = "CUSTOMERS")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUST_NUM")
    private int id;
    @Column(name = "COMPANY")
    private String company;
    @Column(name = "CUST_REP")
    private int custRep;
    @Column(name = "CREDIT_LIMIT")
    private double creditLimit;
    private List<Salesrep> salesrepSet = new ArrayList<Salesrep>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getCustRep() {
        return custRep;
    }

    public void setCustRep(int custRep) {
        this.custRep = custRep;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
}
