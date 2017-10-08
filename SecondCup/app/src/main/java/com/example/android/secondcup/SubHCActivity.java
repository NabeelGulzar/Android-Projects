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

public class SubHCActivity extends baseactivity {
    private List<ItemCategoryMenu> subCategories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_hc);
        subCategories =new ArrayList<>();
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Europeans (Hot or Cold)"));
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Espressos"));
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Tea Lattes"));
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Artisan Infused Teas (Hot or Cold)"));
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Second Cup Specialties"));
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Hot Spicy Apple Cider"));
        subCategories.add(new ItemCategoryMenu(R.mipmap.food,"Flavoured Milk Steamers"));

        ListAdapter categoryAdapter = new CategoriesAdapter(this, subCategories);
        //ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
        final ListView subCategoryList = (ListView)findViewById(R.id.subHCList);
        subCategoryList.setAdapter(categoryAdapter);

        subCategoryList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        ItemCategoryMenu category=(ItemCategoryMenu)parent.getItemAtPosition(position);
                        Toast.makeText(SubHCActivity.this, category.getText(), Toast.LENGTH_SHORT).show();
                        if(position==0)
                        {
                            Intent intent = new Intent(view.getContext(),itemsHCEuActivity.class);
                            startActivity(intent);
                        }
                        else if(position==1)
                        {
                            Intent intent = new Intent(view.getContext(),itemsHCEsActivity.class);
                            startActivity(intent);
                        }
                        else if(position==2)
                        {
                            Intent intent = new Intent(view.getContext(),itemsHCTLActivity.class);
                            startActivity(intent);
                        }
                        else if(position==3)
                        {
                            Intent intent = new Intent(view.getContext(),itemsHCAITActivity.class);
                            startActivity(intent);
                        }
                        else if(position==4)
                        {
                            Intent intent = new Intent(view.getContext(),itemsHCSCSActivity.class);
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
