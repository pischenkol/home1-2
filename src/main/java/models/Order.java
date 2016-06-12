package models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@javax.persistence.Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_NUM")
    private int id;
    @Column(name = "ORDER_DATE")
    private Date orderDate;
    @Column(name = "CAST")
    private int cast;
    @Column(name = "REP")
    private int rep;
    @Column(name = "MTF")
    private String mfr;
    @Column(name = "PRODUCT")
    private String product;
    @Column(name = "QTY")
    private int qty;
    @Column(name = "AMOUNT")
    private double amount;
    private Set<Customer> customers;
    private Set<Salesrep> salesreps;
    private Set<Product> products;

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
