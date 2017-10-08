package com.example.nabee.lab_18sep2017;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GetUserInfoActivity extends AppCompatActivity {

    TextView txtDetail;
    ImageView photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_user_info);

        txtDetail=(TextView)findViewById(R.id.txtDetails);
        photo=(ImageView)findViewById(R.id.imageView);

        Intent i=getIntent();
        String name, lname, email, dob;

        name=i.getStringExtra("FName");
        lname=i.getStringExtra("LName");
        email=i.getStringExtra("Email");
        dob=i.getStringExtra("DOB");

        txtDetail.setText(name+"\n"+lname+"\n"+email+"\n"+dob);

        if(i.hasExtra("Photo"))
        {
            Bitmap bitmap = BitmapFactory.decodeByteArray(i.getByteArrayExtra("Photo"),0,i.getByteArrayExtra("Photo").length);
            Drawable d = new BitmapDrawable(getResources(), bitmap);
            photo.setBackground(d);
        }



    }
}
