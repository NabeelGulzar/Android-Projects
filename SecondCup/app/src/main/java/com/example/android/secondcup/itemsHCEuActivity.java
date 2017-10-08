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

public class itemsHCEuActivity extends baseactivity {
    private List<ItemCategoryMenu> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_hceu);
        items=new ArrayList<>();
        items.add(new ItemCategoryMenu(R.mipmap.food,"Caramel Corretto"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Signature Lattes"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Cappuccino"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Cafe Latte"));
        ListAdapter categoryAdapter = new CategoriesAdapter(this,items);
        //ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
        ListView subCategoryList = (ListView)findViewById(R.id.itemsHCEuList);
        subCategoryList.setAdapter(categoryAdapter);

        subCategoryList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        ItemCategoryMenu category=(ItemCategoryMenu)parent.getItemAtPosition(position);
                        Toast.makeText(itemsHCEuActivity.this, category.getText(), Toast.LENGTH_SHORT).show();
                        if(position==1)
                        {
                            Intent intent = new Intent(view.getContext(),itemsHCEuSSubActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Intent intent = new Intent(view.getContext(),detailActivity.class);
                            intent.putExtra("name",category.getText());
                            intent.putExtra("cat","Europeans (Hot or Cold)");
                            intent.putExtra("img",items.get(position).getImgId());
                            startActivity(intent);
                        }

                    }
                }
        );
    }
}
