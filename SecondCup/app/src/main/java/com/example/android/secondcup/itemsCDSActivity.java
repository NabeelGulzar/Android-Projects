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

public class itemsCDSActivity extends baseactivity {
    private List<ItemCategoryMenu> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_cds);
        items=new ArrayList<>();
        items.add(new ItemCategoryMenu(R.mipmap.food,"Ceaser Salad"));
        items.add(new ItemCategoryMenu(R.mipmap.fruitsalad,"Fruit Salad"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Potato Salad"));
        ListAdapter categoryAdapter = new CategoriesAdapter(this,items);
        //ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
        ListView subCategoryList = (ListView)findViewById(R.id.itemsCDSList);
        subCategoryList.setAdapter(categoryAdapter);

        subCategoryList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        ItemCategoryMenu category=(ItemCategoryMenu)parent.getItemAtPosition(position);
                        Toast.makeText(itemsCDSActivity.this, category.getText(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(view.getContext(),detailActivity.class);
                        intent.putExtra("name",category.getText());
                        intent.putExtra("cat","Salads");
                        intent.putExtra("img",items.get(position).getImgId());
                        startActivity(intent);
                    }
                }
        );
    }
}
