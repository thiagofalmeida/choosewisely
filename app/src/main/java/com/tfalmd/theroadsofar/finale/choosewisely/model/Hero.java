package com.tfalmd.theroadsofar.finale.choosewisely.model;

/**
 * Created by tfalmd on 24/06/15.
 */
public class Hero {
    private String name;
    private int id;
    private int has_id;

    public Hero(int id, String name, int has_id) {
        this.id = id;
        this.name = name;
        this.has_id = has_id;
    }

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

    public int getHas_id() {
        return has_id;
    }

    public void setHas_id(int has_id) {
        this.has_id = has_id;
    }
}
