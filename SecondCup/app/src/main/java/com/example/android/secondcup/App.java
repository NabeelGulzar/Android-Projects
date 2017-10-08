package com.example.android.secondcup;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.android.secondcup.model.dbHandler;

/**
 * Created by nabee on 1/24/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("function","App");
        dbHandler db = new dbHandler(this, null, null, 1);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {
            // <---- run your one time code here
            Log.d("function","First Time");
            db.enterData();
            // mark first time has runned.
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
        }
    }
}
