package com.example.android.secondcup;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

public class configActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch(item.getItemId())
        {
            case android.R.id.home:
            {
                onBackPressed();
                return true;
            }
            case R.id.about:
            {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(configActivity.this);
                a_builder.setTitle("Developed by").setMessage("S.W.A.N. Solutions\nswantech@gmail.com").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
