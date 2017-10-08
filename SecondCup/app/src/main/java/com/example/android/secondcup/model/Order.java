package com.example.android.secondcup.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public String order_time;
    public int table_no;
    List<Item> order;
    public List<Item> getOrder() {
        return order;
    }

    public Order()
    {
        this.order=new ArrayList<Item>();
    }

    public void add(Item item)//id
    {
        for(Item i:order)
        {
            if(i.getName().equals(item.getName()))
            {
                i.setQuantity(i.getQuantity()+item.getQuantity());
                return;
            }
        }
        this.order.add(item);
    }

    public void decrement(int _id)
    {
        for(Item i:order)
        {
            if(i.get_id()==_id)
            {
                if(i.getQuantity()<=1)
                {
                    order.remove(i);
                    return;
                }
                else {
                    i.setQuantity(i.getQuantity() - 1);
                    return;
                }
            }
        }
    }

    public void increment(int _id,dbHandler db)
    {
        for(Item i:order)
        {
            if(i.get_id()==_id)
            {
                i.setQuantity(i.getQuantity() + 1);
                return;
            }
        }
        Item i=db.getItem(_id);
        i.setQuantity(1);
        order.add(i);
    }

}
