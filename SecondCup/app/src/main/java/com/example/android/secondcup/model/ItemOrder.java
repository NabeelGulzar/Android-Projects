package com.example.android.secondcup.model;

/**
 * Created by Sohaib on 1/22/2017.
 */

public class ItemOrder {
    private int id;
    private String textName;
    private int textQuantity;

    public ItemOrder(String textName, int textQuantity, int id) {
        this.textName = textName;
        this.textQuantity = textQuantity;
        this.id=id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getTextQuantity() {
        return textQuantity;
    }

    public void setTextQuantity(int textQuantity) {
        this.textQuantity = textQuantity;
    }

    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }



}
