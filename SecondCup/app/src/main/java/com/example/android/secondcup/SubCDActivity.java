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

public class SubCDActivity extends baseactivity {
    private List<ItemCategoryMenu> subCategories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_cd);
        subCategories=new ArrayList<>();
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Sandwiches & Wraps"));
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Salads"));
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Baked Goods"));
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Muffins"));
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Cakes (Imported)"));
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Cakes (Local)"));
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Cookies"));
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Loaves"));
        ListAdapter categoryAdapter = new CategoriesAdapter(this,subCategories);
        //ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
        ListView subCategoryList = (ListView)findViewById(R.id.subCDList);
        subCategoryList.setAdapter(categoryAdapter);

        subCategoryList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        ItemCategoryMenu category=(ItemCategoryMenu)parent.getItemAtPosition(position);
                        Toast.makeText(SubCDActivity.this, category.getText(), Toast.LENGTH_SHORT).show();
                        if(position==0)
                        {
                            Intent intent = new Intent(view.getContext(),itemsCDSWActivity.class);
                            startActivity(intent);
                        }
                        else if(position==1)
                        {
                            Intent intent = new Intent(view.getContext(),itemsCDSActivity.class);
                            startActivity(intent);
                        }
                        else if(position==2)
                        {
                            Intent intent = new Intent(view.getContext(),itemsCDBGActivity.class);
                            startActivity(intent);
                        }
                        else if(position==3)
                        {
                            Intent intent = new Intent(view.getContext(),itemsCDMActivity.class);
                            startActivity(intent);
                        }
                        else if(position==4)
                        {
                            Intent intent = new Intent(view.getContext(),itemsCDCIActivity.class);
                            startActivity(intent);
                        }
                        else if(position==5)
                        {
                            Intent intent = new Intent(view.getContext(),itemsCDCLActivity.class);
                            startActivity(intent);
                        }
                        else if(position==6)
                        {
                            Intent intent = new Intent(view.getContext(),itemsCDCActivity.class);
                            startActivity(intent);
                        }
                        else if(position==7)
                        {
                            Intent intent = new Intent(view.getContext(),itemsCDLActivity.class);
                            startActivity(intent);
                        }
                    }
                }
        );
    }
}
