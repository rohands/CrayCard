package com.chrisrisner.fragmentsample;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed (new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent (SplashScreen.this, SignUpActivity.class);
                startActivity(i);
                finish ();
            }
        }, SPLASH_TIME_OUT);
    }

}
