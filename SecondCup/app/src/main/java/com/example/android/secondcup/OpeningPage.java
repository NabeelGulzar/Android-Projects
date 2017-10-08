package com.example.android.secondcup;
        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import java.util.Timer;
        import java.util.TimerTask;

public class OpeningPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_page);
        OpeningCheck();
    }
    public void OpeningCheck()
    {
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run(){
                Intent i=new Intent(OpeningPage.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);
    }
}
