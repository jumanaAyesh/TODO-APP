package com.todolist.todolist.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.todolist.todolist.R;

import fragments.LoginFragment;
import fragments.SingUpFragment;
import helperclass.MyFragmentManager;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        MyFragmentManager.getInstance().switchFragmentWithoutBack(new SingUpFragment(),R.id.auth_frame,this);
    }
}