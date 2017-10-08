package com.example.nabee.lab_18sep2017;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.TextView;

public class Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        String text = getString(R.string.about_us);

        Drawable dIcon = getResources().getDrawable(R.drawable.image1);
        int leftMargin = dIcon.getIntrinsicWidth() + 10;

        ImageView icon = (ImageView) findViewById(R.id.icon);
        icon.setBackgroundDrawable(dIcon);

        SpannableString ss = new SpannableString(text);
        ss.setSpan(new MyLeadingMarginSpan2(10, leftMargin), 0, ss.length(), 0);

        TextView messageView = (TextView) findViewById(R.id.message_view);
        messageView.setText(ss);
    }
}
