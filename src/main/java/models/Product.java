package models;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MFR_ID")
    private String id;
    @Column(name="PRODUCT_ID")
    private String productId;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="PRICE")
    private double price;
    @Column(name="QTY_ON_HAND")
    private int qtyOnHand;
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }
}
