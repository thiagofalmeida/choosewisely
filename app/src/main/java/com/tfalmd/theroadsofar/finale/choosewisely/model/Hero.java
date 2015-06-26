package com.tfalmd.theroadsofar.finale.choosewisely.model;

/**
 * Created by tfalmd on 24/06/15.
 */
public class Hero {
    private String name;
    private int id;
    private int hasId;

    public Hero(int id, String name, int hasId) {
        this.id = id;
        this.name = name;
        this.hasId = hasId;
    }

    public Hero() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHasId() {
        return hasId;
    }

    public void setHasId(int hasId) {
        this.hasId = hasId;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", hasId=" + hasId +
                '}';
    }
}
