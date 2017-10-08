package com.example.android.secondcup;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.secondcup.model.ItemCategoryMenu;

import java.util.ArrayList;
import java.util.List;

public class SubBCActivity extends baseactivity {
    private List<ItemCategoryMenu> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_bc);
        items =new ArrayList<>();
        items.add(new ItemCategoryMenu(R.mipmap.food,"Paradiso (Medium Roast)"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Paradiso Dark (Dark Roast)"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"La Minita (Medium Roast)"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Colombian San Agustin (Light Roast)"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Sumatra Mandheling (Medium Dark Roast)"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Cuzco (Medium Roast)"));
        items.add(new ItemCategoryMenu(R.mipmap.food,"Paradiso Dark Swiss Water Decaf (Dark Roast)"));
        ListAdapter categoryAdapter = new CategoriesAdapter(this, items);
        //ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
        ListView subCategoryList = (ListView)findViewById(R.id.subBCList);
        subCategoryList.setAdapter(categoryAdapter);

        subCategoryList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ItemCategoryMenu category=(ItemCategoryMenu)parent.getItemAtPosition(position);
                        Toast.makeText(SubBCActivity.this, category.getText(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(view.getContext(),detailActivity.class);
                        intent.putExtra("name",category.getText());
                        intent.putExtra("cat","");
                        intent.putExtra("img",items.get(position).getImgId());
                        startActivity(intent);
                    }
                }
        );
    }
}
