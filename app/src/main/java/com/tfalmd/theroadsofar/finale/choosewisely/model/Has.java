package com.tfalmd.theroadsofar.finale.choosewisely.model;

/**
 * Created by tfalmd on 24/06/15.
 */
public class Has {
    private int id;
    private int powerId;
    private int heroId;

    public Has(int id, int powerId, int heroId) {
        this.id = id;
        this.powerId = powerId;
        this.heroId = heroId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPowerId() {
        return powerId;
    }

    public void setPowerId(int powerId) {
        this.powerId = powerId;
    }

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }
}
