package com.example.android.secondcup.model;

/**
 * Created by Sohaib on 1/14/2017.
 */

public class ItemCategoryMenu
{
    private int imgId;
    private String text;

    public ItemCategoryMenu(int imgId,String text)
    {
        this.imgId=imgId;
        this.text=text;
    }
    public ItemCategoryMenu(String text)
    {
        this.imgId=0;
        this.text=text;
    }
    public int getImgId() {
        return imgId;
    }

    public String getText() {
        return text;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void setText(String text) {
        this.text = text;
    }
}
