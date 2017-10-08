package com.example.android.secondcup;
import com.example.android.secondcup.model.thread;
import com.google.gson.Gson;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.secondcup.model.Item;
import com.example.android.secondcup.model.ItemOrder;
import com.example.android.secondcup.model.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class orderActivity extends configActivity {
    private List<ItemOrder> list;
    ListAdapter orderAdapter;
    ListView categoryList;
    Button buttonOrder;
    Globals g = Globals.getInstance();
    Order o = g.getOrder();
    TextView textOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        /*if(Globals.orderEmpty==false)
        {*/
        Log.d("Reload","hello");
            textOrder = (TextView) findViewById(R.id.textOrder);
            buttonOrder = (Button) findViewById(R.id.buttonOrder);
            if (o.getOrder().size() < 1) {
                buttonOrder.setEnabled(false);
            }
            else
            {
                list = new ArrayList<ItemOrder>();
                Log.d("Reload","helloas");
                for (Item i : g.getOrder().getOrder()) {
                    //String[] tokens=i.getName().split("-");

                    list.add(new ItemOrder(i.getName(), i.getQuantity(), i.get_id()));
                }
                //categories.add(new ItemCategoryMenu(R.mipmap.food,"Frozen Favourites"));
                orderAdapter = new OrderAdapter(this, list);
                //ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
                categoryList = (ListView) findViewById(R.id.orderList);
                categoryList.setAdapter(orderAdapter);
            }
    }

    @Override
    protected void onPause() {
        Log.d("Reload","PauseB");
        super.onPause();
        Log.d("Reload","PauseA");
    }
    @Override
    protected void onStart() {
        Log.d("Reload","StartB");
        super.onStart();
        Log.d("Reload","StartA");
    }
    @Override
    protected void onResume() {
        Log.d("Reload","ResumeB");
        super.onResume();
        Log.d("Reload","ResumeA");
    }

    public void OnbtnOrderClicked(View v) throws IOException
    {
        if(String.valueOf(Globals.IP) != "null")
        {
            if (o.getOrder().size() > 0) {
                tableActivityDialog obj = new tableActivityDialog(this);
                obj.show();
                Globals.sock = new Client(Globals.IP);
            }
            for (Item i : o.getOrder()) {
                Log.d("OrderD", i.getName() + "\t" + i.getQuantity() + "\t" + i.getUnit_price());
            }
        }
        else
        {
            Toast.makeText(orderActivity.this, "IP Address not defined.", Toast.LENGTH_SHORT).show();
        }
    }
    public class Client extends thread
    {
        Socket socket;
        PrintWriter out;
        BufferedReader read;
        String ip;
        public Client(String ip) throws IOException {
            this.ip=ip;
        }
        @Override
        public void run() {
            super.run();
            try {
                String json=new Gson().toJson(Globals.getInstance().getOrder());
                //Log.i("tttttt",json);
                this.socket=new Socket(this.ip,8080);
                out=new PrintWriter(socket.getOutputStream(),true);
                read=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out.println(json);
                out.flush();
                out.close();
                socket.close();
                orderActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run()
                    {
                        Toast.makeText(orderActivity.this, "Order Sent", Toast.LENGTH_SHORT).show();
                        categoryList.setAdapter(null);
                        list.clear();
                        g.getOrder().getOrder().clear();
                        orderActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                buttonOrder.setEnabled(false);
                            }
                        });
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                orderActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(orderActivity.this, "Server Not Connected", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }
}