package com.example.nabee.lab_18sep2017;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ForBackgroundActivity extends AppCompatActivity {


    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_background);

        layout=(ConstraintLayout)findViewById(R.id.layout);

        Log.d("Activity","Background");
        Intent i=getIntent();
        if(i.hasExtra("picture")) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(
                    i.getByteArrayExtra("picture"),0,i.getByteArrayExtra("picture").length);

            Drawable d = new BitmapDrawable(getResources(), bitmap);

            layout.setBackground(d);
        }
    }
}
