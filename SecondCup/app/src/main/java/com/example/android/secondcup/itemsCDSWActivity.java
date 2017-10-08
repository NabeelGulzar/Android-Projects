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

public class itemsCDSWActivity extends baseactivity {
    private List<ItemCategoryMenu> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_cd_sw);
        items=new ArrayList<>();
        items.add(new ItemCategoryMenu(R.mipmap.food,"Chicken Wrap"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Grilled Chicken Pita"));
        items.add(new ItemCategoryMenu(R.mipmap.chickensubtandoori,"Chicken Sub Tandoori"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Cheese & Tomato"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Smoke Chicken Panini"));
        items.add(new ItemCategoryMenu(R.mipmap.sandwichtwo,"Chicken Teriyaki Sandwich"));
        items.add(new ItemCategoryMenu(R.mipmap.sandwichone,"Chicken Club Sandwich"));
        items.add(new ItemCategoryMenu(R.mipmap.sandwichtwo,"Chicken Enchiladas"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Pizza"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Quiche"));
        ListAdapter categoryAdapter = new CategoriesAdapter(this,items);
        //ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
        ListView subCategoryList = (ListView)findViewById(R.id.itemsCDSWList);
        subCategoryList.setAdapter(categoryAdapter);

        subCategoryList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        ItemCategoryMenu category=(ItemCategoryMenu)parent.getItemAtPosition(position);
                        Toast.makeText(itemsCDSWActivity.this, category.getText(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(view.getContext(),detailActivity.class);
                        intent.putExtra("name",category.getText());
                        intent.putExtra("cat","Sandwiches & Wraps");
                        intent.putExtra("img",items.get(position).getImgId());
                        startActivity(intent);
                    }
                }
        );
    }
}
