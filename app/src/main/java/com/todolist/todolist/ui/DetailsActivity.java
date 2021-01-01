package com.todolist.todolist.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.todolist.todolist.R;

import java.util.ArrayList;

import adapter.ListAdapter;
import adapter.Task;
import adapter.TaskAdapter;
import adapter.ToDoLists;

public class DetailsActivity extends AppCompatActivity {

    ArrayList<Task> tasks = new ArrayList<>();
    RecyclerView tasksRecyclerView ;
    TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tasksRecyclerView= findViewById(R.id.tasksRC);

        tasks.add(new Task("Assinment",true));
        tasks.add(new Task("Art",true));
        tasks.add(new Task("Number",true));
        tasks.add(new Task("Ways",true));

        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new TaskAdapter(this ,tasks);
        tasksRecyclerView.setAdapter(taskAdapter);
        taskAdapter.notifyDataSetChanged();



    }
}