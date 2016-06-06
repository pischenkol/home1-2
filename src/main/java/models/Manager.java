package models;

import javax.persistence.Entity;

@Entity
public class Manager {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
