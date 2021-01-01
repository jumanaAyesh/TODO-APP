package com.todolist.todolist.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.todolist.todolist.R;

import java.util.ArrayList;

import adapter.ListAdapter;
import adapter.ToDoLists;

public class MainActivity extends AppCompatActivity {

    ArrayList<ToDoLists> toDoLists = new ArrayList<>();
    RecyclerView toDoListRecyclerView ;
    ListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoListRecyclerView = findViewById(R.id.toDoListRecyclerView);
        toDoLists.add(new ToDoLists("Assinment",3));
        toDoLists.add(new ToDoLists("Art",6));
        toDoLists.add(new ToDoLists("Number",7));
        toDoLists.add(new ToDoLists("Ways",8));
        toDoListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        listAdapter = new ListAdapter(this ,toDoLists );
        toDoListRecyclerView.setAdapter(listAdapter);
    }
}