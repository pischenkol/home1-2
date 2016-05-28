package models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by appleface on 26.05.16.
 */
public class Order {
    private int id;
    private Date orderDate;
    private int cast;
    private int rep;
    private String mfr;
    private String product;
    private int qty;
    private double amount;
    private Set<Customer> customers = new HashSet<>();
    private Set<Salesrep> salesreps = new HashSet<>();
    private Set<Product> products = new HashSet<>();

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Set<Salesrep> getSalesreps() {
        return salesreps;
    }

    public void setSalesreps(Set<Salesrep> salesreps) {
        this.salesreps = salesreps;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getCast() {
        return cast;
    }

    public void setCast(int cast) {
        this.cast = cast;
    }

    public int getRep() {
        return rep;
    }

    public void setRep(int rep) {
        this.rep = rep;
    }

    public String getMfr() {
        return mfr;
    }

    public void setMfr(String mfr) {
        this.mfr = mfr;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
