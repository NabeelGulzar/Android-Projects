package com.example.android.secondcup.model;

/**
 * Created by nabee on 1/21/2017.
 */

public class Menu {
    private int _id;
    private String name;
    private String description;
    private int price;

    public Menu()
    {}

    public Menu(String name, String description, int price) {
        this.name=name;
        this.description = description;
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_id() {
        return _id;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
