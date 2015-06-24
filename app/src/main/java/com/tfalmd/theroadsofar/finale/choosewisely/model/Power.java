package com.tfalmd.theroadsofar.finale.choosewisely.model;

/**
 * Created by tfalmd on 24/06/15.
 */
public class Power {
    private int id;
    private String name;
    private String advantage;
    private String disadvantage;
    private int utility;
    private String imageFile;

    public Power(int id, String name, String advantage, String disadvantage, int utility, String imageFile) {
        this.id = id;
        this.name = name;
        this.advantage = advantage;
        this.disadvantage = disadvantage;
        this.utility = utility;
        this.imageFile = imageFile;
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

    public String getAdvantage() {
        return advantage;
    }

    public void setAdvantage(String advantage) {
        this.advantage = advantage;
    }

    public String getDisadvantage() {
        return disadvantage;
    }

    public void setDisadvantage(String disadvantage) {
        this.disadvantage = disadvantage;
    }

    public int getUtility() {
        return utility;
    }

    public void setUtility(int utility) {
        this.utility = utility;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }
}
