package com.example.android.secondcup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.secondcup.model.Item;
import com.example.android.secondcup.model.ItemCategoryMenu;
import com.example.android.secondcup.model.ItemOrder;
import com.example.android.secondcup.model.Order;
import com.example.android.secondcup.model.dbHandler;

import java.util.List;

/**
 * Created by Sohaib on 1/22/2017.
 */

public class OrderAdapter extends ArrayAdapter<ItemOrder>
{
    private List<ItemOrder> listCategories;
    //private Context con;
    private Order o;
    //ItemOrder orderItem;
    //TextView textItemOQuantity;
    Globals g=Globals.getInstance();
    public OrderAdapter(Context context, List<ItemOrder> categories) {
        super(context, R.layout.custom_row_order ,categories);
        //con=context;
        this.listCategories=categories;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        // default -  return super.getView(position, convertView, parent);
        // add the layout
        LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
        View customView = myCustomInflater.inflate(R.layout.custom_row_order, parent, false);
        final View myView = myCustomInflater.inflate(R.layout.activity_order, parent, false);
        // get references.
        final ItemOrder orderItem = getItem(position);
        TextView textItemOName = (TextView) customView.findViewById(R.id.textItemOName);
        final TextView textItemOQuantity = (TextView) customView.findViewById(R.id.textItemOQuantity);
        textItemOName.setText(orderItem.getTextName().replace('-',' '));
        textItemOQuantity.setText(Integer.toString(orderItem.getTextQuantity()));

        Button buttonOInc=(Button) customView.findViewById(R.id.buttonOInc);
        o=g.getOrder();
        buttonOInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Context c=parent.getContext();
                textItemOQuantity.setText(Integer.toString(Integer.parseInt(textItemOQuantity.getText().toString())+1));
                o.increment(orderItem.getId(),new dbHandler(parent.getContext(),null,null,1));
                g.setOrder(o);
                for(Item i:o.getOrder())
                {
                    Log.d("Order",i.getName()+"\t"+i.getQuantity()+"\t"+i.getUnit_price());
                }
            }
        });
        Button buttonODec=(Button) customView.findViewById(R.id.buttonODec);
        //final Button buttonOrder=(Button) myView.findViewById(R.id.buttonOrder);
        buttonODec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                if(Integer.parseInt(textItemOQuantity.getText().toString()) > 0) {
                    textItemOQuantity.setText(Integer.toString(Integer.parseInt(textItemOQuantity.getText().toString()) - 1));
                    o.decrement(orderItem.getId());
                    g.setOrder(o);
                    for (Item i : o.getOrder()) {
                        Log.d("OrderD", i.getName() + "\t" + i.getQuantity() + "\t" + i.getUnit_price());
                    }
                }
                else if(o.getOrder().size() == 0)
                {
                    Globals.orderEmpty=true;
                }
            }
        });

        return customView;
    }
}
