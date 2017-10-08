package com.example.nabee.lab_18sep2017;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class PersonalInfoActivity extends AppCompatActivity {


    ImageView imageView;
    AutoCompleteTextView fName,lName;
    EditText txtEmail,txtDob;

    private static final String[] FNames = new String[] {
            "Abdul", "Imran", "Nabeel", "Haider", "Muhammad"
    };

    private static final String[] LNames = new String[] {
            "Khan", "Ali", "Rabbani", "Malik", "Sethi"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);


        fName = (AutoCompleteTextView) findViewById(R.id.txtFName);
        lName = (AutoCompleteTextView) findViewById(R.id.txtLName);
        imageView=(ImageView)findViewById(R.id.imageView);
        txtEmail=(EditText)findViewById(R.id.txtEmail);
        txtDob=(EditText)findViewById(R.id.txtDOB);

        ArrayAdapter<String> fName_adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, FNames);
        ArrayAdapter<String> lName_adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, LNames);


        fName.setAdapter(fName_adapter);
        lName.setAdapter(lName_adapter);

    }

    public void SelectImage(View view)
    {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1888);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == 1888 && resultCode == Activity.RESULT_OK)
        {
            Bitmap photo=(Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);

        }
    }

    public void Submit(View view)
    {
        String fname=fName.getText().toString();
        String lname=lName.getText().toString();
        String DOB=txtEmail.getText().toString();
        String email=txtDob.getText().toString();
        if(!txtEmail.getText().toString().contains("@"))
        {
            Toast.makeText(this, "Invalid Email", Toast.LENGTH_LONG).show();
        }
        else
        {
            if(!(fname.isEmpty()||lname.isEmpty()||email.isEmpty()||DOB.isEmpty()))
            {

                try
                {
                    Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byte[] b = stream.toByteArray();
                    Intent i = new Intent(getBaseContext(), GetUserInfoActivity.class);
                    i.putExtra("FName", fname);
                    i.putExtra("LName", lname);
                    i.putExtra("Email", email);
                    i.putExtra("DOB", DOB);
                    i.putExtra("Photo", b);
                    startActivity(i);
                }
                catch (Exception ex)
                {
                    Toast.makeText(this, "Please Select Image.",Toast.LENGTH_LONG).show();
                }

            }
            else
            {
                Toast.makeText(this, "One ir more fields missing.",Toast.LENGTH_LONG).show();
            }
        }

    }



}
