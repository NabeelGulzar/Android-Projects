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

public class SubFFActivity extends baseactivity {
    private List<ItemCategoryMenu> subCategories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_ff);
        subCategories=new ArrayList<>();
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Chillers"));
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Fruit Chillers"));
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Fresh Squeezed Orange Juice"));
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Handcrafted Italian Sodas"));
        ListAdapter categoryAdapter = new CategoriesAdapter(this,subCategories);
        //ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
        ListView subCategoryList = (ListView)findViewById(R.id.subFFList);
        subCategoryList.setAdapter(categoryAdapter);

        subCategoryList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        ItemCategoryMenu category=(ItemCategoryMenu)parent.getItemAtPosition(position);
                        Toast.makeText(SubFFActivity.this, category.getText(), Toast.LENGTH_SHORT).show();
                        if(position==0)
                        {
                            Intent intent = new Intent(view.getContext(),itemsFFCActivity.class);
                            startActivity(intent);
                        }
                        else if(position==1)
                        {
                            Intent intent = new Intent(view.getContext(),itemsFFFCActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Intent intent = new Intent(view.getContext(),detailActivity.class);
                            intent.putExtra("name",category.getText());
                            intent.putExtra("cat","");
                            intent.putExtra("img",subCategories.get(position).getImgId());
                            startActivity(intent);
                        }
                    }
                }
        );
    }
}
