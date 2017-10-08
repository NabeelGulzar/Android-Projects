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

public class itemsHCEsActivity extends baseactivity {
    private List<ItemCategoryMenu> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_hces);
        items=new ArrayList<>();
        items.add(new ItemCategoryMenu(R.mipmap.food,"Espresso"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Macchiato"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Americano"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Con Panna"));
        ListAdapter categoryAdapter = new CategoriesAdapter(this,items);
        //ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
        ListView subCategoryList = (ListView)findViewById(R.id.itemsHCEsList);
        subCategoryList.setAdapter(categoryAdapter);

        subCategoryList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        ItemCategoryMenu category=(ItemCategoryMenu)parent.getItemAtPosition(position);
                        Toast.makeText(itemsHCEsActivity.this, category.getText(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(view.getContext(),detailActivity.class);
                        intent.putExtra("name",category.getText());
                        intent.putExtra("cat","Espressos");
                        intent.putExtra("img",items.get(position).getImgId());
                        startActivity(intent);

                    }
                }
        );
    }
}