package com.example.android.secondcup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.secondcup.model.ItemCategoryMenu;

import java.util.ArrayList;
import java.util.List;

public class SubANFYActivity extends baseactivity {
    private List<ItemCategoryMenu> subCategories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_anfy);
        subCategories=new ArrayList<>();
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Smoothies"));
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Shakes"));
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Parfaits"));
        ListAdapter categoryAdapter = new CategoriesAdapter(this,subCategories);
        //ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
        ListView subCategoryList = (ListView)findViewById(R.id.subANFYList);
        subCategoryList.setAdapter(categoryAdapter);

        subCategoryList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ItemCategoryMenu category=(ItemCategoryMenu)parent.getItemAtPosition(position);
                        Toast.makeText(SubANFYActivity.this, category.getText(), Toast.LENGTH_SHORT).show();
                        if(position==0)
                        {
                            Intent intent = new Intent(view.getContext(),itemsANFYSmActivity.class);
                            startActivity(intent);
                        }
                        else if(position==1)
                        {
                            Intent intent = new Intent(view.getContext(),itemsANFYShActivity.class);
                            startActivity(intent);
                        }
                        else if(position==2)
                        {
                            Intent intent = new Intent(view.getContext(),itemsANFYPActivity.class);
                            startActivity(intent);
                        }
                    }
                }
        );
    }
}
