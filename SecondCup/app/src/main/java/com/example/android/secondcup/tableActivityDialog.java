package com.example.android.secondcup;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.secondcup.model.Order;
import com.google.gson.Gson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import static com.example.android.secondcup.orderActivity.*;

/**
 * Created by Sohaib on 1/26/2017.
 */

public class tableActivityDialog extends Dialog implements View.OnClickListener {
        Globals g=Globals.getInstance();
        public Activity c;
        public Dialog d;
        public Button okay;
        public EditText table;
        Order o = g.getOrder();
        public tableActivityDialog(Activity a) {
            super(a);
            // TODO Auto-generated constructor stub
            this.c = a;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            this.setCanceledOnTouchOutside(false);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.custom_dialog);
            okay = (Button) findViewById(R.id.btn_okay);
            okay.setOnClickListener(this);

        }

        @Override
        public void onClick(View v)
        {
            table=(EditText) findViewById(R.id.input_table);
            switch (v.getId()) {
                case R.id.btn_okay:
                    Log.d("Button", table.getText().toString());
                    g.getOrder().table_no=Integer.parseInt(table.getText().toString());
                    dismiss();
                    Gson gson = new Gson();
                    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Karachi"));
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    o.order_time = sdf.format(cal.getTime());

                    Globals.sock.start();
                    break;
                default:
                    break;
            }
            dismiss();
        }
    }
