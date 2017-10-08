package com.example.nabee.lab_11sep2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class OrderDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        Log.d("Activity", "Result");

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String total = intent.getStringExtra("Total");
        String bev = intent.getStringExtra("Beverages");
        String veg = intent.getStringExtra("Veg");
        String chicken = intent.getStringExtra("Chicken");
        String salami = intent.getStringExtra("Salami");
        String bevName = intent.getStringExtra("BevName");
        String pizzaSize = intent.getStringExtra("PizzaSize");


        Log.d("Cheeck", "2");

        Log.d("Veg",veg);
        Log.d("Salami",salami);
        Log.d("Chicken",chicken);
        Log.d("Name",name);
        Log.d("Total",total);
        Log.d("Bev",bev);

        Log.d("Cheeck", "2");
        TextView txtDetail=(TextView) findViewById(R.id.txtDetail);
        txtDetail.setText("Name: "+ name+"\n"+
                "Beverage Name: "+ bevName+"\n"+
                "Pizza Size: "+ pizzaSize+"\n"+
                "Beverages: "+ bev+"\n"+
                "Veg: "+ veg+"\n"+
                "Salami: "+ salami+"\n"+
                "Chicken: "+chicken+"\n"+
                "Price: "+total);



    }
}
