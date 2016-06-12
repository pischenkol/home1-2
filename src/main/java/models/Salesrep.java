package models;



import javax.persistence.Entity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "SALESREPS")
public class Salesrep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPL_NUM")
    private int id;
    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private int age;

    @Column(name = "REP_OFFICE")
    private int repOffice;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "HIRE_DATE")
    private Date hireDate;

    @OneToOne
    @JoinColumn(name = "MGR")
    private Manager manager;

    @Column(name = "QUOTA")
    private double quota;

    @Column(name = "SELES")
    private double sales;


    private Set<Salesrep> salesreps;

    private Set<Office> offices;

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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
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
