package com.example.nabee.lab_18sep2017;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImageDetail extends AppCompatActivity {

    ImageView imgView;
    Button btnSetLayout;
    TextView txtDescription;
    LinearLayout layoutDetail;
    LinearLayout layoutMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        imgView=(ImageView)findViewById(R.id.imageView5);
        btnSetLayout=(Button)findViewById(R.id.btnSetLayout);
        layoutDetail=(LinearLayout)findViewById(R.id.layoutDetail);
        layoutMain=(LinearLayout)findViewById(R.id.layoutMain);
        txtDescription=(TextView)findViewById(R.id.txtDescription);


        Intent i = getIntent();
        final int resourceId=i.getIntExtra("Image",R.drawable.placeholder);


        Log.d("ImageId:2",String.valueOf(resourceId));

        imgView.setBackgroundResource(resourceId);
        txtDescription.setText(i.getStringExtra("Description"));

        btnSetLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                imgView.setVisibility(View.INVISIBLE);
                layoutDetail.setBackgroundResource(resourceId);
                txtDescription.setTextColor(Color.WHITE);
//                layoutMain.setBackgroundResource(resourceId);
            }
        });
    }
}
