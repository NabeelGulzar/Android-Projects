package com.example.nabee.lab_25sep2017;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

//    TextView txtTimer;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 //       txtTimer = (TextView) findViewById(R.id.txtCounter);
        imageView=(ImageView)findViewById(R.id.imageView);
    }

//    public void StartTimer(View view)
//    {
//        Log.d("Pos", "1");
//        CountDownTimer timer=new CountDownTimer(15000,1000)
//        {
//            @Override
//            public void onTick(long l)
//            {
//                Log.d("Pos", "2");
//                txtTimer.setText("Value: "+l);
//            }
//
//            @Override
//            public void onFinish()
//            {
//                Log.d("Pos", "3");
//                Toast.makeText(MainActivity.this,"Done!",Toast.LENGTH_SHORT).show();
//            }
//        }.start();
//    }

//    public void ShowMap(View view)
//    {
//        Uri temp= Uri.parse("geo:37.9845,-122.4268?q=schools");
//        Intent x=new Intent(Intent.ACTION_VIEW,temp);
//        x.setPackage("com.google.android.apps.maps");
//        if(x.resolveActivity(getPackageManager())!=null)
//        {
//            startActivity(x);
//        }
//        else
//        {
//            Toast.makeText(MainActivity.this,"Package not found!",Toast.LENGTH_SHORT).show();
//        }
//    }

//    public void SendSMS(View view) {
//        String phoneNumber = "+923339941482";
//        String message = "Hello! This is a test message";
//        SmsManager temp = SmsManager.getDefault();
//        temp.sendTextMessage(phoneNumber, null, message, null, null);
//        Toast.makeText(this, "Here", Toast.LENGTH_SHORT).show();
//    }

    public void CaptureImage(View view)
    {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1888);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == 1888 && resultCode == Activity.RESULT_OK)
        {
            Bitmap photo=(Bitmap) data.getExtras().get("data");
//            imageView.setImageBitmap(photo);
            ByteArrayOutputStream _bs = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG, 50, _bs);
            Intent i=new Intent(getBaseContext(),Main2Activity.class);
            i.putExtra("byteArray", _bs.toByteArray());
            startActivity(i);
        }
    }
}

