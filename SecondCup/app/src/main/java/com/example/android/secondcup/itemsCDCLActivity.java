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

public class itemsCDCLActivity extends baseactivity {
    private List<ItemCategoryMenu> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_cdcl);
        items=new ArrayList<>();
        items.add(new ItemCategoryMenu(R.mipmap.food,"Chocolate Mousse Cake"));
        items.add(new ItemCategoryMenu(R.mipmap.chocolatefudgecake,"Devil Fudge Cake"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Carrot Cake"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Death By Chocolate Cake"));
        items.add(new ItemCategoryMenu(R.mipmap.brownie,"Brownie (Simple)"));
        items.add(new ItemCategoryMenu(R.mipmap.brownieice,"Brownie with Ice-cream"));
        ListAdapter categoryAdapter = new CategoriesAdapter(this,items);
        ListView subCategoryList = (ListView)findViewById(R.id.itemsCDCLList);
        subCategoryList.setAdapter(categoryAdapter);

        subCategoryList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        ItemCategoryMenu category=(ItemCategoryMenu)parent.getItemAtPosition(position);
                        Toast.makeText(itemsCDCLActivity.this, category.getText(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(view.getContext(),detailActivity.class);
                        intent.putExtra("name" , category.getText());
                        intent.putExtra("cat","Cakes(Local)");
                        intent.putExtra("img",items.get(position).getImgId());
                        startActivity(intent);
                    }
                }
        );
    }
}
