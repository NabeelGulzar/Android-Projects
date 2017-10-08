package com.example.nabee.lab_11sep2017;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    CheckBox cbSalami, cbChicken, cbVeg;
    EditText txtName, txtBevCount, txtTotal;
    RadioGroup rgSize;
    Spinner spnrBeverages;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.d("Position","0");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Position","1");

        intent=new Intent(this, OrderDetail.class);

        txtName=(EditText) findViewById(R.id.txtName);
        txtBevCount=(EditText) findViewById(R.id.txtBevCount);
        txtTotal=(EditText) findViewById(R.id.txtTotalAmount);

        cbSalami=(CheckBox) findViewById(R.id.cbSalami);
        cbChicken=(CheckBox) findViewById(R.id.cbChicken);
        cbVeg=(CheckBox) findViewById(R.id.cbVeg);

        txtTotal.setEnabled(false);

        rgSize=(RadioGroup)findViewById(R.id.rdoGroup);
        spnrBeverages=(Spinner)findViewById(R.id.spnrBeverage);

        Log.d("Position","2");

        rgSize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i)
                {
                    case R.id.rdoSmall:
                        intent.putExtra("PizzaSize","Small");
                        break;
                    case R.id.rdoMedium:
                        intent.putExtra("PizzaSize","Small");
                        break;
                    case R.id.rdoLarge:
                        intent.putExtra("PizzaSize","Small");
                        break;
                }
            }
        });

        Log.d("Position","3");

        spnrBeverages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:
                        intent.putExtra("BevName","7up");
                        break;
                    case 1:
                        intent.putExtra("BevName","Fanta");
                        break;
                    case 2:
                        intent.putExtra("BevName","Coca Cola");
                    break;
                    case 3:
                        intent.putExtra("BevName","Dew");
                        break;
                    case 4:
                        intent.putExtra("BevName","Water");
                        break;
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void SendOrder(View view)
    {


        if(txtName.getText().toString().isEmpty())
            return;


        String veg="false",salami="false",chick="false";



        if(cbSalami.isChecked())
            salami="true";

        if(cbChicken.isChecked())
            chick="true";

        if(cbVeg.isChecked())
            veg="true";


        intent.putExtra("Salami",salami);
        intent.putExtra("Veg",veg);
        intent.putExtra("Chicken",chick);

        intent.putExtra("Total",String.valueOf(25* Integer.parseInt(txtBevCount.getText().toString())));
        intent.putExtra("Name",cbSalami.getText().toString());
        intent.putExtra("Beverages",txtBevCount.getText().toString());

        Log.d("Activity", "Main");
        startActivity(intent);



    }
}
