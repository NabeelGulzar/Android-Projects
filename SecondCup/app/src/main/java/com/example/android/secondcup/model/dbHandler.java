package com.example.android.secondcup.model;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class dbHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME= "restaurant.db";
    private static final String TABLE_MENU= "menu";
    private static final String MENU_COLUMN_ID="_id";
    private static final String MENU_COLUMN_NAME="name";
    private static final String MENU_COLUMN_DESCRIPTION="description";
    private static final String MENU_COLUMN_PRICE="price";

    //We need to pass database information along to superclass
    public dbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            String query = "CREATE TABLE IF NOT EXISTS " + TABLE_MENU + " (" +
                    MENU_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    MENU_COLUMN_NAME + " TEXT, " +
                    MENU_COLUMN_PRICE + " INTEGER, " +
                    MENU_COLUMN_DESCRIPTION + " TEXT " +
                    ");";
            db.execSQL(query);
     //       enterData();

        }
        catch (Exception ex)
        {
            Log.d("Exception",ex.getMessage());
        }
        Log.d("Function","onDatabaseCreate");
    }
    //Lesson 51
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MENU);
        onCreate(db);
        Log.d("Function","onUpgrade");
    }

    //Add a new row to the database
//    public void addProduct(Products product){
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_PRODUCTNAME, product.get_productname());
//        SQLiteDatabase db = getWritableDatabase();
//        db.insert(TABLE_PRODUCTS, null, values);
//        db.close();
//    }

    public void addItem(Menu menu)
    {
        ContentValues values = new ContentValues();
        values.put(MENU_COLUMN_NAME, menu.getName());
        values.put(MENU_COLUMN_DESCRIPTION, menu.getDescription());
        values.put(MENU_COLUMN_PRICE, menu.getPrice());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_MENU, null, values);
        db.close();
        //Log.d("Function","addItem");
    }
    public void deleteItem(String name)
    {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_MENU + " WHERE " + MENU_COLUMN_NAME + "= '" + name + "';");
        Log.d("Function","deleteItem");
    }
    public void deleteMenu()
    {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_MENU + " WHERE 1;");
        Log.d("Function","deleteMenu");
    }

    //Delete a product from the database
//    public void deleteProduct(String productName){
//        SQLiteDatabase db = getWritableDatabase();
//        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME + "=\"" + productName + "\";");
//    }
    public List<Item> getItems(String name)
    {
        SQLiteDatabase db=getWritableDatabase();
        List<Item> items = new ArrayList<Item>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_MENU +" WHERE "+MENU_COLUMN_NAME+" like '"+name+"%';", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if ((cursor.getString(cursor.getColumnIndex(MENU_COLUMN_NAME))) != null)
            {
                String _name=cursor.getString(cursor.getColumnIndex(MENU_COLUMN_NAME));
                String _description=cursor.getString(cursor.getColumnIndex(MENU_COLUMN_DESCRIPTION));
                int _price=cursor.getInt(cursor.getColumnIndex(MENU_COLUMN_PRICE));
                Item i=new Item(_name,_price,0);
                i.set_id(cursor.getInt(cursor.getColumnIndex(MENU_COLUMN_ID)));
                i.setDescription(cursor.getString(cursor.getColumnIndex(MENU_COLUMN_DESCRIPTION)));
                items.add(i);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return items;
    }

    public Item getItem(int id)
    {
        SQLiteDatabase db=getWritableDatabase();
        Item item = new Item();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_MENU +" WHERE "+MENU_COLUMN_ID+" = "+id+";", null);
        cursor.moveToFirst();
            if ((cursor.getString(cursor.getColumnIndex(MENU_COLUMN_NAME))) != null)
            {
                String _name=cursor.getString(cursor.getColumnIndex(MENU_COLUMN_NAME));
                String _description=cursor.getString(cursor.getColumnIndex(MENU_COLUMN_DESCRIPTION));
                int _price=cursor.getInt(cursor.getColumnIndex(MENU_COLUMN_PRICE));
                Item i=new Item(_name,_price,0);
                i.set_id(cursor.getInt(cursor.getColumnIndex(MENU_COLUMN_ID)));
                i.setDescription(cursor.getString(cursor.getColumnIndex(MENU_COLUMN_DESCRIPTION)));

                item=i;
                cursor.close();
            }
        else{
                cursor.close();
                return null;
            }
        return item;
    }


    public String showTables()
    {
        String s="";
        SQLiteDatabase db=getWritableDatabase();
        List<String> tables = new ArrayList<String>();
        Cursor cursor = db.rawQuery("SELECT * FROM sqlite_master WHERE type='table';", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String tableName = cursor.getString(1);
            if (!tableName.equals("android_metadata") && !tableName.equals("sqlite_sequence"))
                tables.add(tableName);
            cursor.moveToNext();
        }
        cursor.close();

        for(String tableName:tables) {
            s+=tableName+"\n";
        }
        return s;
    }

    public String getMenu()
    {
        try {
            String dbString = "";
            SQLiteDatabase db = getWritableDatabase();
            String query = "SELECT * FROM " + TABLE_MENU + " WHERE 1";

            Cursor c = db.rawQuery(query, null);
            c.moveToFirst();

            while (!c.isAfterLast()) {
                if ((c.getString(c.getColumnIndex(MENU_COLUMN_NAME))) != null) {
                    dbString += (c.getString(c.getColumnIndex(MENU_COLUMN_ID)) + "\t" + c.getString(c.getColumnIndex(MENU_COLUMN_NAME)) + "\t" + c.getString(c.getColumnIndex(MENU_COLUMN_PRICE)) + "\n" + c.getString(c.getColumnIndex(MENU_COLUMN_DESCRIPTION)));
                    dbString += "\n";
                }
                Log.d("DB", (c.getString(c.getColumnIndex(MENU_COLUMN_ID)) + "\t" + c.getString(c.getColumnIndex(MENU_COLUMN_NAME)) + "\t" + c.getString(c.getColumnIndex(MENU_COLUMN_PRICE)) + "\n" + c.getString(c.getColumnIndex(MENU_COLUMN_DESCRIPTION))));
                c.moveToNext();
            }

            db.close();
            Log.d("Function", "getDatabase");
            return dbString;
        }
        catch(Exception ex) {
            Log.d("Exception", ex.getMessage());

        }
        return new String("");
    }
    public void enterData()
    {
        // addUser(new User("Nabeel","123456"));
        addItem(new Menu("Smoothies-Berry Passion-Small","",390));
        addItem(new Menu("Smoothies-Berry Passion-Medium","",440));
        addItem(new Menu("Smoothies-Berry Passion-Large","",490));

        addItem(new Menu("Smoothies-Strawberry Banana-Small","", 390));
        addItem(new Menu("Smoothies-Strawberry Banana-Medium","", 440));
        addItem(new Menu("Smoothies-Strawberry Banana-Large","", 490));

        addItem(new Menu("Smoothies-Clementine Mango-Small","",390));
        addItem(new Menu("Smoothies-Clementine Mango-Medium","",440));
        addItem(new Menu("Smoothies-Clementine Mango-Large","",490));

        addItem(new Menu("Smoothies-Chocolate/Caramel Temptation-Small","",390));
        addItem(new Menu("Smoothies-Chocolate/Caramel Temptation-Medium","",440));
        addItem(new Menu("Smoothies-Chocolate/Caramel Temptation-Large","",490));

        addItem(new Menu("Shakes-Mocha Mania-Small","",390));
        addItem(new Menu("Shakes-Mocha Mania-Medium","",440));
        addItem(new Menu("Shakes-Mocha Mania-Large","",490));

        addItem(new Menu("Shakes-Cookie Crumble-Small","",390));
        addItem(new Menu("Shakes-Cookie Crumble-Medium","",440));
        addItem(new Menu("Shakes-Cookie Crumble-Large","",490));

        addItem(new Menu("Shakes-Berried in Caramel-Small","",390));
        addItem(new Menu("Shakes-Berried in Caramel-Medium","",440));
        addItem(new Menu("Shakes-Berried in Caramel-Large","",490));

        addItem(new Menu("Shakes-Dreamsicle Lite-Small","",390));
        addItem(new Menu("Shakes-Dreamsicle Lite-Medium","",440));
        addItem(new Menu("Shakes-Dreamsicle Lite-Large","",490));

        addItem(new Menu("Parfaits-Mixed Berry-Small","",390));
        addItem(new Menu("Parfaits-Mixed Berry Meduim","",440));

        addItem(new Menu("Parfaits-Strawberry Banana-Small","",390));
        addItem(new Menu("Parfaits-Strawberry Banana-Medium","",440));

        addItem(new Menu("Parfaits-Granola & Honey-Small","",390));
        addItem(new Menu("Parfaits-Granola & Honey-Medium","",440));

        addItem(new Menu("Parfaits-Chocolate/Caramel Temptation-Small","",390));
        addItem(new Menu("Parfaits-Chocolate/Caramel Temptation-Medium","",440));

        addItem(new Menu("Chillers-Icepresso-Small","",330));
        addItem(new Menu("Chillers-Icepresso-Medium","",370));
        addItem(new Menu("Chillers-Icepresso-Large","",395));

        addItem(new Menu("Chillers-Mocha Icepresso-Small","",345));
        addItem(new Menu("Chillers-Mocha Icepresso-Medium","",395));
        addItem(new Menu("Chillers-Mocha Icepresso-Large","",425));

        addItem(new Menu("Chillers-Caramel Icepresso-Small","",345));
        addItem(new Menu("Chillers-Caramel Icepresso-Medium","",395));
        addItem(new Menu("Chillers-Caramel Icepresso-Large","",425));

        addItem(new Menu("Chillers-Vanilla Bean Icepresso-Small","",345));
        addItem(new Menu("Chillers-Vanilla Bean Icepresso-Medium","",395));
        addItem(new Menu("Chillers-Vanilla Bean Icepresso-Large","",425));

        addItem(new Menu("Chillers-Chillatte-Small","",345));
        addItem(new Menu("Chillers-Chillatte-Medium","",395));
        addItem(new Menu("Chillers-Chillatte-Large","",425));

        addItem(new Menu("Chillers-Frrrozen Hot Chocolate (Creamy)-Small","",345));
        addItem(new Menu("Chillers-Frrrozen Hot Chocolate (Creamy)-Medium","",395));
        addItem(new Menu("Chillers-Frrrozen Hot Chocolate (Creamy)-Large","",425));

        addItem(new Menu("Chillers-Frrrozen Hot Chocolate (Dark)-Small","",345));
        addItem(new Menu("Chillers-Frrrozen Hot Chocolate (Dark)-Medium","",395));
        addItem(new Menu("Chillers-Frrrozen Hot Chocolate (Dark)-Large","",425));

        addItem(new Menu("Chillers-Maple White Hot Chocolate-Small","",345));
        addItem(new Menu("Chillers-Maple White Hot Chocolate-Medium","",395));
        addItem(new Menu("Chillers-Maple White Hot Chocolate-Large","",425));

        addItem(new Menu("Chillers-Cookies & Cream-Small","",345));
        addItem(new Menu("Chillers-Cookies & Cream-Medium","",395));
        addItem(new Menu("Chillers-Cookies & Cream-Large","",425));

        addItem(new Menu("Chillers-Chai Chiller-Small","",330));
        addItem(new Menu("Chillers-Chai Chiller-Medium","",370));
        addItem(new Menu("Chillers-Chai Chiller-Large","",395));

        addItem(new Menu("Chillers-Green Tea Chiller-Small","",330));
        addItem(new Menu("Chillers-Green Tea Chiller-Medium","",370));
        addItem(new Menu("Chillers-Green Tea Chiller-Large","",395));

        addItem(new Menu("Fruit Chillers-Mint Lemonade-Small","",350));
        addItem(new Menu("Fruit Chillers-Mint Lemonade-Medium","",395));
        addItem(new Menu("Fruit Chillers-Mint Lemonade-Large","",345));

        addItem(new Menu("Fruit Chillers-Strawberry Lemonade-Small","",350));
        addItem(new Menu("Fruit Chillers-Strawberry Lemonade-Medium","",395));
        addItem(new Menu("Fruit Chillers-Strawberry Lemonade-Large","",345));

        addItem(new Menu("Fruit Chillers-Mango-Small","",350));
        addItem(new Menu("Fruit Chillers-Mango-Medium","",395));
        addItem(new Menu("Fruit Chillers-Mango-Large","",345));

        addItem(new Menu("Fruit Chillers-Strawberry (Simple)-Small","",350));
        addItem(new Menu("Fruit Chillers-Strawberry (Simple)-Medium","",395));
        addItem(new Menu("Fruit Chillers-Strawberry (Simple)-Large","",345));

        addItem(new Menu("Fruit Chillers-Banana-Small","",350));
        addItem(new Menu("Fruit Chillers-Banana-Medium","",395));
        addItem(new Menu("Fruit Chillers-Banana-Large","",345));

        addItem(new Menu("Fruit Chillers-Peach-Small","",350));
        addItem(new Menu("Fruit Chillers-Peach-Medium","",395));
        addItem(new Menu("Fruit Chillers-Peach-Large","",345));

        addItem(new Menu("Fruit Chillers-Wildberry-Small","",350));
        addItem(new Menu("Fruit Chillers-Wildberry-Medium","",395));
        addItem(new Menu("Fruit Chillers-Wildberry-Large","",345));

        addItem(new Menu("-Fresh Squeezed Orange Juice-Small","",395));
        addItem(new Menu("-Fresh Squeezed Orange Juice-Medium","",495));
        addItem(new Menu("-Fresh Squeezed Orange Juice-Large","",595));

        addItem(new Menu("-Handcrafted Italian Sodas-Small","",395));
        addItem(new Menu("-Handcrafted Italian Sodas-Medium","",495));
        addItem(new Menu("-Handcrafted Italian Sodas-Large","",595));

        addItem(new Menu("Europeans (Hot or Cold)-Caramel Corretto-Small","",330));
        addItem(new Menu("Europeans (Hot or Cold)-Caramel Corretto-Medium","",370));
        addItem(new Menu("Europeans (Hot or Cold)-Caramel Corretto-Large","",395));

        addItem(new Menu("Europeans (Hot or Cold)-Signature Lattes-Vanilla Bean-Small","",330));
        addItem(new Menu("Europeans (Hot or Cold)-Signature Lattes-Vanilla Bean-Medium","",370));
        addItem(new Menu("Europeans (Hot or Cold)-Signature Lattes-Vanilla Bean-Large","",395));

        addItem(new Menu("Europeans (Hot or Cold)-Signature Lattes-Hazelnut-Small","",330));
        addItem(new Menu("Europeans (Hot or Cold)-Signature Lattes-Hazelnut-Medium","",370));
        addItem(new Menu("Europeans (Hot or Cold)-Signature Lattes-Hazelnut-Large","",395));

        addItem(new Menu("Europeans (Hot or Cold)-Signature Lattes-Butternut-Small","",330));
        addItem(new Menu("Europeans (Hot or Cold)-Signature Lattes-Butternut-Medium","",370));
        addItem(new Menu("Europeans (Hot or Cold)-Signature Lattes-Butternut-Large","",395));

        addItem(new Menu("Europeans (Hot or Cold)-Signature Lattes-Moccaccino-Small","",330));
        addItem(new Menu("Europeans (Hot or Cold)-Signature Lattes-Moccaccino-Medium","",370));
        addItem(new Menu("Europeans (Hot or Cold)-Signature Lattes-Moccaccino-Large","",395));


        addItem(new Menu("Europeans (Hot or Cold)-Signature Lattes-White Moccha-Small","",330));
        addItem(new Menu("Europeans (Hot or Cold)-Signature Lattes-White Moccha-Medium","",370));
        addItem(new Menu("Europeans (Hot or Cold)-Signature Lattes-White Moccha-Large","",395));

        addItem(new Menu("Europeans (Hot or Cold)-Signature Lattes-Maple-Small","",330));
        addItem(new Menu("Europeans (Hot or Cold)-Signature Lattes-Maple-Medium","",370));
        addItem(new Menu("Europeans (Hot or Cold)-Signature Lattes-Maple-Large","",395));

        addItem(new Menu("Europeans (Hot or Cold)-Cappuccino-Small","",290));
        addItem(new Menu("Europeans (Hot or Cold)-Cappuccino-Medium","",330));
        addItem(new Menu("Europeans (Hot or Cold)-Cappuccino-Large","",370));

        addItem(new Menu("Europeans (Hot or Cold)-Cafe Latte-Small","",290));
        addItem(new Menu("Europeans (Hot or Cold)-Cafe Latte-Medium","",330));
        addItem(new Menu("Europeans (Hot or Cold)-Cafe Latte-Large","",370));

        addItem(new Menu("Espressos-Espresso-Single","",225));
        addItem(new Menu("Espressos-Espresso-Double","",250));

        addItem(new Menu("Espressos-Macchiato-Single","",225));
        addItem(new Menu("Espressos-Macchiato-Double","",250));

        addItem(new Menu("Espressos-Americano-Single","",225));
        addItem(new Menu("Espressos-Americano-Double","",250));

        addItem(new Menu("Espressos-Con Panna-Single","",225));
        addItem(new Menu("Espressos-Con Panna-Double","",250));

        addItem(new Menu("Tea Lattes-Chai Latte-Small","",290));
        addItem(new Menu("Tea Lattes-Chai Latte-Medium","",330));
        addItem(new Menu("Tea Lattes-Chai Latte-Large","",370));

        addItem(new Menu("Tea Lattes-London Fog-Small","",290));
        addItem(new Menu("Tea Lattes-London Fog-Medium","",330));
        addItem(new Menu("Tea Lattes-London Fog-Large","",370));

        addItem(new Menu("Tea Lattes-Green Tea-Small","",290));
        addItem(new Menu("Tea Lattes-Green Tea-Medium","",330));
        addItem(new Menu("Tea Lattes-Green Tea-Large","",370));


        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-English Breakfast-Small","",190));
        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-English Breakfast-Medium","",230));
        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-English Breakfast-Large","",270));

        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Earl Grey-Small","",190));
        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Earl Grey Breakfast-Medium","",230));
        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Earl Grey-Large","",270));

        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Chai-Small","",190));
        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Chai-Medium","",230));
        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Chai-Large","",270));

        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Green Moroccan Mint-Small","",190));
        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Green Moroccan Mint-Medium","",230));
        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Green Moroccan Mint-Large","",270));

        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Jasmine Green-Small","",190));
        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Jasmine Green-Medium","",230));
        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Jasmine Green-Large","",270));

        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Wildberry Tisane-Small","",190));
        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Wildberry Tisane-Medium","",230));
        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Wildberry Tisane-Large","",270));

        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Chamomile Tisane-Small","",190));
        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Chamomile Tisane-Medium","",230));
        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Chamomile Tisane-Large","",270));

        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Cardamom-Small","",190));
        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Cardamom-Medium","",230));
        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Cardamom-Large","",270));

        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Tropical Green Tea-Small","",190));
        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Tropical Green Tea-Medium","",230));
        addItem(new Menu("Artisan Infused Teas (Hot or Cold)-Tropical Green Tea-Large","",270));


        addItem(new Menu("Second Cup Specialties-Creamy Hot Chocolate-Small","",330));
        addItem(new Menu("Second Cup Specialties-Creamy Hot Chocolate-Medium","",370));
        addItem(new Menu("Second Cup Specialties-Creamy Hot Chocolate-Large","",395));

        addItem(new Menu("Second Cup Specialties-Dark Hot Chocolate-Small","",330));
        addItem(new Menu("Second Cup Specialties-Dark Hot Chocolate-Medium","",370));
        addItem(new Menu("Second Cup Specialties-Dark Hot Chocolate-Large","",395));

        addItem(new Menu("Second Cup Specialties-White Hot Chocolate-Small","",330));
        addItem(new Menu("Second Cup Specialties-White Hot Chocolate-Medium","",370));
        addItem(new Menu("Second Cup Specialties-White Hot Chocolate-Large","",395));

        addItem(new Menu("Second Cup Specialties-Vanilla Bean Hot Chocolate-Small","",330));
        addItem(new Menu("Second Cup Specialties-Vanilla Bean Hot Chocolate-Medium","",370));
        addItem(new Menu("Second Cup Specialties-Vanilla Bean Hot Chocolate-Large","",395));

	addItem(new Menu("Second Cup Specialties-Maple White Hot Chocolate-Small","",330));
        addItem(new Menu("Second Cup Specialties-Maple White Hot Chocolate-Medium","",370));
        addItem(new Menu("Second Cup Specialties-Maple White Hot Chocolate-Large","",395));

        addItem(new Menu("-Hot Spicy Apple Cider-Small","",330));
        addItem(new Menu("-Hot Spicy Apple Cider-Medium","",370));
        addItem(new Menu("-Hot Spicy Apple Cider-Large","",395));

        addItem(new Menu("-Flavoured Milk Steamers-Small","",195));
        addItem(new Menu("-Flavoured Milk Steamers-Medium","",225));
        addItem(new Menu("-Flavoured Milk Steamers-Large","",250));

        addItem(new Menu("Cakes(Imported)-Baked New York Cheese Cake-Slice","",395));

        addItem(new Menu("Cakes(Imported)-Strawberry Swirl Cheese Cake-Slice","",350));

        addItem(new Menu("Cakes(Imported)-Heavenly Chocolate Cheese Cake-Slice","",350));

        addItem(new Menu("Cakes(Imported)-Chocolate Overload Torte-Slice","",450));

        addItem(new Menu("Cakes(Imported)-SC Chocolicious Cake-Slice","",450));

        addItem(new Menu("Cakes(Imported)-Caramel Almond Brownie-Slice","",250));

        addItem(new Menu("Cakes(Imported)-NY Style Iced Chocolate Eclair-Slice","",250));

        addItem(new Menu("Cakes(Local)-Chocolate Mousse Cake-Slice","",250));
        addItem(new Menu("Cakes(Local)-Chocolate Mousse Cake-Whole","",1795));

        addItem(new Menu("Cakes(Local)-Devil Fudge Cake-Slice","",275));
        addItem(new Menu("Cakes(Local)-Devil Fudge Cake-Whole","",1895));

        addItem(new Menu("Cakes(Local)-Death by Chocolate Cake-Slice","",295));
        addItem(new Menu("Cakes(Local)-Death by Chocolate Cake-Whole","",1995));

        addItem(new Menu("Cakes(Local)-Carrot Cake-Slice","",330));
        addItem(new Menu("Cakes(Local)-Carrot Cake-Whole","",2195));

        addItem(new Menu("Cakes(Local)-Brownie (Simple)-Slice","",225));

        addItem(new Menu("Cakes(Local)-Brownie with Ice-cream-Slice","",275));

        addItem(new Menu("Cookies-Double Chocolate-Simple","",175));

        addItem(new Menu("Cookies-Chocolate Chip-Simple","",175));

        addItem(new Menu("Loaves-Marble Loaf-Simple","",195));

        addItem(new Menu("Loaves-Banana Loaf-Simple","",195));

        addItem(new Menu("Sandwiches & Wraps-Chicken Wrap-Simple","",450));

        addItem(new Menu("Sandwiches & Wraps-Grilled Chicken Pita-Simple","",450));

        addItem(new Menu("Sandwiches & Wraps-Chicken Sub Tandoori-Simple","",450));

        addItem(new Menu("Sandwiches & Wraps-Cheese & Tomato-Simple","",350));

        addItem(new Menu("Sandwiches & Wraps-Smoke Chicken Panini-Simple","",450));

        addItem(new Menu("Sandwiches & Wraps-Chicken Teriyaki Sandwich-Simple","",425));

        addItem(new Menu("Sandwiches & Wraps-Chicken Club Sandwich-Simple","",425));

        addItem(new Menu("Sandwiches & Wraps-Chicken Enchiladas-Simple","",375));

        addItem(new Menu("Sandwiches & Wraps-Pizza-Simple","",250));

        addItem(new Menu("Sandwiches & Wraps-Quiche-Simple","",250));

        addItem(new Menu("Salads-Ceaser Salad-Simple","",350));

        addItem(new Menu("Salads-Fruit Salad-Simple","",350));

        addItem(new Menu("Salads-Potato Salad-Simple","",295));

        addItem(new Menu("Baked Goods-Butter Croissant-Simple","",195));
        addItem(new Menu("Baked Goods-Cheese Croissant-Simple","",195));
        addItem(new Menu("Baked Goods-Chocolate Croissant-Simple","",195));

        addItem(new Menu("Muffins-Plain-Simple","",195));
        addItem(new Menu("Muffins-Blue Berry-Simple","",195));
        addItem(new Menu("Muffins-Double Chocolate-Simple","",195));
        addItem(new Menu("Muffins-Chocolate Chip-Simple","",195));
        addItem(new Menu("Muffins-Apple Cinnamon-Simple","",195));

        addItem(new Menu("-Paradiso (Medium Roast)-Small","Our signature blend with rich and smooth notes",225));
        addItem(new Menu("-Paradiso (Medium Roast)-Medium","Our signature blend with rich and smooth notes",250));
        addItem(new Menu("-Paradiso (Medium Roast)-Large","Our signature blend with rich and smooth notes",275));

        addItem(new Menu("-Paradiso Dark (Dark Roast)-Small","Our premium blend dark roasted with a deep, sweet and full body",225));
        addItem(new Menu("-Paradiso Dark (Dark Roast)-Medium","Our premium blend dark roasted with a deep, sweet and full body",250));
        addItem(new Menu("-Paradiso Dark (Dark Roast)-Large","Our premium blend dark roasted with a deep, sweet and full body",275));

        addItem(new Menu("-La Minita (Medium Roast)-Small","Sweet and fruity aroma with rich flavor from Costa Rica",225));
        addItem(new Menu("-La Minita (Medium Roast)-Medium","Sweet and fruity aroma with rich flavor from Costa Rica",250));
        addItem(new Menu("-La Minita (Medium Roast)-Large","Sweet and fruity aroma with rich flavor from Costa Rica",275));

        addItem(new Menu("-Colombian San Agustin (Light Roast)-Small","Exceptional aroma and smooth bright flavor from Colombia",225));
        addItem(new Menu("-Colombian San Agustin (Light Roast)-Medium","Exceptional aroma and smooth bright flavor from Colombia",250));
        addItem(new Menu("-Colombian San Agustin (Light Roast)-Large","Exceptional aroma and smooth bright flavor from Colombia",275));

        addItem(new Menu("-Sumatra Mandheling (Medium Dark Roast)-Small","A sweet coffee with earthy notes, bold full body from Indonesia",225));
        addItem(new Menu("-Sumatra Mandheling (Medium Dark Roast)-Medium","A sweet coffee with earthy notes, bold full body from Indonesia",225));
        addItem(new Menu("-Sumatra Mandheling (Medium Dark Roast)-Large","A sweet coffee with earthy notes, bold full body from Indonesia",225));

        addItem(new Menu("-Cuzco (Medium Roast)-Small","Nutty chocolate notes from Latin America",225));
        addItem(new Menu("-Cuzco (Medium Roast)-Medium","Nutty chocolate notes from Latin America",250));
        addItem(new Menu("-Cuzco (Medium Roast)-Large","Nutty chocolate notes from Latin America",275));

        addItem(new Menu("-Paradiso Dark Swiss Water Decaf (Dark Roast)-Small","Full bodied with smokey flavor and a hint of cocoa",225));
        addItem(new Menu("-Paradiso Dark Swiss Water Decaf (Dark Roast)-Medium","Full bodied with smokey flavor and a hint of cocoa",250));
        addItem(new Menu("-Paradiso Dark Swiss Water Decaf (Dark Roast)-Large","Full bodied with smokey flavor and a hint of cocoa",275));

    }

    // this is goint in record_TextView in the Main activity.
//    public String databaseToString(){
//        String dbString = "";
//        SQLiteDatabase db = getWritableDatabase();
//        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE 1";// why not leave out the WHERE  clause?
//
//        //Cursor points to a location in your results
//        Cursor recordSet = db.rawQuery(query, null);
//        //Move to the first row in your results
//        recordSet.moveToFirst();
//
//        //Position after the last row means the end of the results
//        while (!recordSet.isAfterLast()) {
//            // null could happen if we used our empty constructor
//            if (recordSet.getString(recordSet.getColumnIndex("productname")) != null) {
//                dbString += recordSet.getString(recordSet.getColumnIndex("productname"));
//                dbString += "\n";
//            }
//            recordSet.moveToNext();
//        }
//        db.close();
//        return dbString;
//    }

}