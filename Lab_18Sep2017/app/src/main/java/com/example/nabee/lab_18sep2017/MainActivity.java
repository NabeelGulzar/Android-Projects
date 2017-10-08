package com.example.nabee.lab_18sep2017;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {


    ToggleButton btnToggle;
    LinearLayout layoutMain;
    Switch btnSwitch;
    RadioGroup rg;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutMain=(LinearLayout)findViewById(R.id.layoutMain);
        btnSwitch=(Switch)findViewById(R.id.swt);
        btnToggle=(ToggleButton)findViewById(R.id.toggleButton);
        rg=(RadioGroup)findViewById(R.id.rg1);
        spinner=(Spinner)findViewById(R.id.spinner);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                switch (i)
                {
                    case 0:
                        Toast.makeText(getApplicationContext(),"CS",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"EE",Toast.LENGTH_SHORT).show();
                        layoutMain.setBackgroundColor(Color.GREEN);
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"AF",Toast.LENGTH_SHORT).show();
                        layoutMain.setBackgroundColor(Color.RED);
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(),"BBA",Toast.LENGTH_SHORT).show();
                        layoutMain.setBackgroundColor(Color.GRAY);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i)
            {
                switch (i)
                {
                    case R.id.rdoCS:
                    Toast.makeText(getApplicationContext(),"CS",Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.rdoEE:
                    Toast.makeText(getApplicationContext(),"EE",Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.rdoFSM:
                    Toast.makeText(getApplicationContext(),"FSM",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(b)
                    Toast.makeText(getApplicationContext(),"On",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Off",Toast.LENGTH_SHORT).show();

            }
        });

        btnSwitch.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view)
            {
                Toast.makeText(getApplicationContext(),"Long Clicked",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    public void OpenDialer(View view)
    {
//        Log.d("Test","1");
//        Intent intent=new Intent(Intent.ACTION_DIAL);
//        Log.d("Test","2");
//        intent.setData(Uri.parse("tel:03339941482"));
//        Log.d("Test","3");
//        startActivity(intent);
//

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://almondmendoza.com/android-applications/"));
        startActivity(i);
    }
}
