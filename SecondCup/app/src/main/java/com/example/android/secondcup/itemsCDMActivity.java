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

public class itemsCDMActivity extends baseactivity {
    private List<ItemCategoryMenu> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_cdm);
        items=new ArrayList<>();
        items.add(new ItemCategoryMenu(R.mipmap.food,"Plain"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Blue Berry"));
        items.add(new ItemCategoryMenu(R.mipmap.doublechocolatemuffin,"Double Chocolate"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Chocolate Chip"));
        items.add(new ItemCategoryMenu(R.mipmap.apple,"Apple Cinnamon"));

        ListAdapter categoryAdapter = new CategoriesAdapter(this,items);
        //ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
        ListView subCategoryList = (ListView)findViewById(R.id.itemsCDMList);
        subCategoryList.setAdapter(categoryAdapter);

        subCategoryList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        ItemCategoryMenu category=(ItemCategoryMenu)parent.getItemAtPosition(position);
                        Toast.makeText(itemsCDMActivity.this, category.getText(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(view.getContext(),detailActivity.class);
                        intent.putExtra("name",category.getText());
                        intent.putExtra("cat","Muffins");
                        intent.putExtra("img",items.get(position).getImgId());
                        startActivity(intent);
                    }
                }
        );
    }
}
