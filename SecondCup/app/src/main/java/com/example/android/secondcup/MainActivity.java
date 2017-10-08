package com.example.android.secondcup;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.secondcup.model.ItemCategoryMenu;
import com.example.android.secondcup.model.Order;
import com.example.android.secondcup.model.dbHandler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends baseactivity {

    private List<ItemCategoryMenu> categories;
    private dbHandler db;
    Globals g=Globals.getInstance();

    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder a_builder=new AlertDialog.Builder(this);
        a_builder.setTitle("Alert").setMessage("Do you want to exit?").setCancelable(false).setPositiveButton("Yes",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("k","lk");
        g.setOrder(new Order());
        categories=new ArrayList<>();
        categories.add(new ItemCategoryMenu(R.mipmap.food,"Cafe Delights"));
        categories.add(new ItemCategoryMenu(R.mipmap.food,"Handcrafted Classics"));
        categories.add(new ItemCategoryMenu(R.mipmap.food,"Barista Crafted (Perfect Cup)"));
        categories.add(new ItemCategoryMenu(R.mipmap.food,"All Natural Frozen Yogurt"));
        categories.add(new ItemCategoryMenu(R.mipmap.food,"Frozen Favourites"));
        ListAdapter categoryAdapter = new CategoriesAdapter(this,categories);
                //ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
        ListView categoryList = (ListView)findViewById(R.id.categoryList);
        categoryList.setAdapter(categoryAdapter);

        categoryList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        ItemCategoryMenu category=(ItemCategoryMenu)parent.getItemAtPosition(position);
                        Toast.makeText(MainActivity.this, category.getText(), Toast.LENGTH_SHORT).show();
                        if(position==0)
                        {
                            Intent intent = new Intent(view.getContext(),SubCDActivity.class);
                            startActivity(intent);
                        }
                        else if(position==1)
                        {
                            Intent intent = new Intent(view.getContext(),SubHCActivity.class);
                            startActivity(intent);
                        }
                        else if(position==2)
                        {
                            Intent intent = new Intent(view.getContext(),SubBCActivity.class);
                            startActivity(intent);
                        }
                        else if(position==3)
                        {
                            Intent intent = new Intent(view.getContext(),SubANFYActivity.class);
                            startActivity(intent);
                        }
                        else if(position==4)
                        {
                            Intent intent = new Intent(view.getContext(),SubFFActivity.class);
                            startActivity(intent);
                        }
                    }
                }
        );
    }
}
