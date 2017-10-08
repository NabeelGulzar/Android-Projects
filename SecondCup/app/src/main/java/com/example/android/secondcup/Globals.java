package com.example.android.secondcup;

import com.example.android.secondcup.model.Order;
import com.example.android.secondcup.model.dbHandler;

import java.net.Socket;

/**
 * Created by Sohaib on 1/21/2017.
 */

public class Globals {
    private static Globals instance;
    public static Socket socket=null;
    private static int count=0;
    private static Order order;
    public static String IP;
    public static orderActivity.Client sock = null;
    public static boolean orderEmpty=true;
    private Globals()
    {

    }
    public Order getOrder() {
        return Globals.order;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Globals.count = count;
    }

    public void setOrder(Order order) {
        Globals.order = order;
    }
    public static synchronized Globals getInstance()
    {
        if(instance == null)
        {
            instance=new Globals();
        }
            return instance;
    }



}
