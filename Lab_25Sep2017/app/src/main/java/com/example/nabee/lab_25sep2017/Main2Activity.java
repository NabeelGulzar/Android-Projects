package com.example.nabee.lab_25sep2017;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Main2Activity extends AppCompatActivity {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        layout=(LinearLayout) findViewById(R.id.layout_second);


        Intent i=getIntent();
        if(i.hasExtra("byteArray")) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(
                    getIntent().getByteArrayExtra("byteArray"),0,getIntent().getByteArrayExtra("byteArray").length);

            Drawable d = new BitmapDrawable(getResources(), bitmap);

            layout.setBackground(d);
        }
    }
}
