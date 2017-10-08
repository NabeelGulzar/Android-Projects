package com.example.android.secondcup.model;

/**
 * Created by nabee on 1/21/2017.
 */

public class Item {
    private int _id;
    private String name;
    private int unit_price;
    private int quantity;
    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {

        this._id = _id;
    }


    public Item()
    {}

    public Item(String name, int unit_price, int quantity)
    {

        this.name=name;
        this.unit_price=unit_price;
        this.quantity=quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnit_price(int unit_price) {
        this.unit_price = unit_price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getUnit_price() {
        return unit_price;
    }

    public int getQuantity() {
        return quantity;
    }
}
