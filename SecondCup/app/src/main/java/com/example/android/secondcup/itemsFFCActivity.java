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

public class itemsFFCActivity extends baseactivity {
    private List<ItemCategoryMenu> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_ffc);
        items=new ArrayList<>();
        items.add(new ItemCategoryMenu(R.mipmap.food,"Icepresso"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Mocha Icepresso"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Caramel Icepresso"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Vanilla Bean Icepresso"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Chillatte"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Frrrozen Hot Chocolate (Creamy)"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Frrrozen Hot Chocolate (Dark)"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Maple White Hot Chocolate"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Chai Chiller"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Green Tea Chiller"));
        ListAdapter categoryAdapter = new CategoriesAdapter(this,items);
        ListView subCategoryList = (ListView)findViewById(R.id.itemsFFCList);
        subCategoryList.setAdapter(categoryAdapter);

        subCategoryList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        ItemCategoryMenu category=(ItemCategoryMenu)parent.getItemAtPosition(position);
                        Toast.makeText(itemsFFCActivity.this, category.getText(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(view.getContext(),detailActivity.class);
                        intent.putExtra("name",category.getText());
                        intent.putExtra("cat","Chillers");
                        intent.putExtra("img",items.get(position).getImgId());
                        startActivity(intent);
                    }
                }
        );
    }
}
