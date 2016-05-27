package models;

/**
 * Created by appleface on 26.05.16.
 */
public class Customer {
    private int id;
    private String company;
    private int custRep;
    private double creditLimit;

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
