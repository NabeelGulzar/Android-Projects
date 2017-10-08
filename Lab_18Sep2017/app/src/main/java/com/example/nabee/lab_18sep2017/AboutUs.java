package com.example.nabee.lab_18sep2017;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        //<=23 API have to take permission in activity explicitly
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_PHONE_STATE},1);
    }

    public void SendSMS(View view)
    {
        try
        {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("03339941482", null, "Hello! this is a test SMS from contact us activity.", null, null);
            Toast.makeText(this, "Sms Sent", Toast.LENGTH_SHORT).show();
        }catch (Exception ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
            Log.d("Error",ex.getMessage());
        }
    }


    public void Call(View view)
    {
        try {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:03339941482"));
            startActivity(intent);
        }
        catch(Exception ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }
}
