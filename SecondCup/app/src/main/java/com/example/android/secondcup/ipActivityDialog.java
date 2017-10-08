package com.example.android.secondcup;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Sohaib on 1/26/2017.
 */

public class ipActivityDialog extends Dialog implements View.OnClickListener {
    public Activity c;
    public Dialog d;
    public Button okay;
    public EditText table;
    public ipActivityDialog(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setCanceledOnTouchOutside(false);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_ip_dialog);
        okay = (Button) findViewById(R.id.btn_connect);
        okay.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        table=(EditText) findViewById(R.id.input_ip);
        switch (v.getId()) {
            case R.id.btn_connect:
                Log.d("Button", table.getText().toString());
                Globals.IP=table.getText().toString();
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
