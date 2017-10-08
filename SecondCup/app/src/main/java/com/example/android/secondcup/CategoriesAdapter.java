package com.example.android.secondcup;

/**
 * Created by Sohaib on 1/14/2017.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.secondcup.model.ItemCategoryMenu;

import java.util.List;

class CategoriesAdapter extends ArrayAdapter<ItemCategoryMenu>{

    private List<ItemCategoryMenu> listCategories;

    public CategoriesAdapter(Context context, List<ItemCategoryMenu> categories) {
        super(context, R.layout.custom_row ,categories);
        this.listCategories=categories;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // default -  return super.getView(position, convertView, parent);
        // add the layout
        LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
        View customView = myCustomInflater.inflate(R.layout.custom_row, parent, false);
        // get references.
        ItemCategoryMenu categoryItem = getItem(position);
        TextView itemText = (TextView) customView.findViewById(R.id.itemText);
        ImageView itemImage = (ImageView) customView.findViewById(R.id.itemImage);
        // dynamically update the text from the array
        itemText.setText(categoryItem.getText());
        // using the same image every time
        itemImage.setImageResource(categoryItem.getImgId());
        // Now we can finally return our custom View or custom item
        return customView;
    }
}

