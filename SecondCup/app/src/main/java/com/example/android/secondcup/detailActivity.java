package com.example.android.secondcup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.secondcup.model.Item;
import com.example.android.secondcup.model.Order;
import com.example.android.secondcup.model.dbHandler;

import java.util.List;

public class detailActivity extends baseactivity {
    String name,cat;
    int imgId;
    TextView textDetail;
    TextView textDescription;
    TextView textSmall;
    TextView textMedium;
    TextView textLarge;
    TextView textSmallPrice;
    TextView textMediumPrice;
    TextView textLargePrice;
    Button buttonSmall;
    Button buttonMedium;
    Button buttonLarge;
    de.hdodenhof.circleimageview.CircleImageView circleImageView;
    List<Item> items;
    Globals g=Globals.getInstance();

    public void btnSmallClicked(View v)
    {
        Order o=g.getOrder();
        o.increment(items.get(0).get_id(),new dbHandler(this,null,null,1));
        g.setOrder(o);
        Globals.orderEmpty=false;
        Toast.makeText(detailActivity.this, "Item Added", Toast.LENGTH_SHORT).show();
        //printOrder(o);
    }
    public void btnMediumClicked(View v)
    {
        Order o=g.getOrder();
        o.increment(items.get(1).get_id(),new dbHandler(this,null,null,1));
        Globals.orderEmpty=false;
        g.setOrder(o);
        Toast.makeText(detailActivity.this, "Item Added", Toast.LENGTH_SHORT).show();
        //printOrder(o);
        //v.playSoundEffect(android.view.SoundEffectConstants.CLICK);
    }
    public void btnLargeClicked(View v)
    {
        Order o=g.getOrder();
        o.increment(items.get(2).get_id(),new dbHandler(this,null,null,1));
        Globals.orderEmpty=false;
        g.setOrder(o);
        Toast.makeText(detailActivity.this, "Item Added", Toast.LENGTH_SHORT).show();
        //printOrder(o);
        //v.playSoundEffect(android.view.SoundEffectConstants.CLICK);
    }


    public void printOrder(Order o)
    {
        for(Item i:o.getOrder())
        {
            Log.d("Order",i.getName()+"\t"+i.getQuantity()+"\t"+i.getUnit_price());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textDetail=(TextView)findViewById(R.id.textDetail);
        textDescription=(TextView)findViewById(R.id.textDescription);
        textSmall=(TextView)findViewById(R.id.textSmall);
        textMedium=(TextView)findViewById(R.id.textMedium);
        textLarge=(TextView)findViewById(R.id.textLarge);
        textSmallPrice=(TextView)findViewById(R.id.textSmallPrice);
        textMediumPrice=(TextView)findViewById(R.id.textMediumPrice);
        textLargePrice=(TextView)findViewById(R.id.textLargePrice);
        buttonSmall=(Button)findViewById(R.id.buttonSmall);
        buttonMedium=(Button)findViewById(R.id.buttonMedium);
        buttonLarge=(Button)findViewById(R.id.buttonLarge);
        circleImageView=(de.hdodenhof.circleimageview.CircleImageView)findViewById(R.id.circleImageViewDetail);

        textMedium.setVisibility(View.INVISIBLE);
        textMediumPrice.setVisibility(View.INVISIBLE);
        textLarge.setVisibility(View.INVISIBLE);
        textLargePrice.setVisibility(View.INVISIBLE);
        buttonMedium.setVisibility(View.INVISIBLE);
        buttonLarge.setVisibility(View.INVISIBLE);

        Intent intent = getIntent();
        name=intent.getStringExtra("name");
        cat=intent.getStringExtra("cat");
        imgId=intent.getIntExtra("img",0);
        textDetail.setText(name);
        dbHandler db=new dbHandler(this,null,null,1);
        items=db.getItems(cat + "-" + name);
        String[] names;
        circleImageView.setImageResource(imgId);
        switch (items.size())
        {
            case 1:
                textDescription.setText(items.get(0).getDescription());
                names=items.get(0).getName().split("-");
                textSmall.setText(names[names.length-1]);
                textSmallPrice.setText(Integer.toString(items.get(0).getUnit_price()));
                //
                Log.d("Function","Case Small");
                break;
            case 2:
                textDescription.setText(items.get(0).getDescription());

                names=items.get(0).getName().split("-");
                textSmall.setText(names[names.length-1]);
                textSmallPrice.setText(Integer.toString(items.get(0).getUnit_price()));
                names=items.get(1).getName().split("-");
                textMedium.setText(names[names.length-1]);
                textMedium.setVisibility(View.VISIBLE);
                textMediumPrice.setVisibility(View.VISIBLE);
                textMediumPrice.setText(Integer.toString(items.get(1).getUnit_price()));
                buttonMedium.setVisibility(View.VISIBLE);
                break;
            case 3:
                textDescription.setText(items.get(0).getDescription());

                names=items.get(0).getName().split("-");
                textSmall.setText(names[names.length-1]);
                textSmallPrice.setText(Integer.toString(items.get(0).getUnit_price()));
                names=items.get(1).getName().split("-");
                textMedium.setText(names[names.length-1]);
                textMedium.setVisibility(View.VISIBLE);
                textMediumPrice.setVisibility(View.VISIBLE);
                textMediumPrice.setText(Integer.toString(items.get(1).getUnit_price()));
                buttonMedium.setVisibility(View.VISIBLE);
                names=items.get(2).getName().split("-");
                textLarge.setVisibility(View.VISIBLE);
                textLargePrice.setVisibility(View.VISIBLE);
                textLarge.setText(names[names.length-1]);
                textLargePrice.setText(Integer.toString(items.get(2).getUnit_price()));
                buttonLarge.setVisibility(View.VISIBLE);
                Log.d("Function","Case Large");
                break;
            default:

        }
//        g.setOrder(g.getOrder().add(new Item(cat+"-"+name)));
    }
}
