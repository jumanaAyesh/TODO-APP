package com.todolist.todolist.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.todolist.todolist.R;

public class SplashActivity extends AppCompatActivity {

    private int SPLASH_DISPLAY_LENGTH = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        AppCompatTextView next = findViewById(R.id.next);
        next.setOnClickListener(v -> {
            startActivity(new Intent(SplashActivity.this, AuthActivity.class));
            finish();
        });


//        new Handler().postDelayed(() -> {
//            startActivity(new Intent(SplashActivity.this, AuthActivity.class));
//            finish();
//        }, SPLASH_DISPLAY_LENGTH );
    }
}