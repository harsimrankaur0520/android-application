package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Volunteer extends AppCompatActivity {



    private LinearLayoutManager mlayoutManager;
    private List<modelclass>
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requester);
        getSupportActionBar().setTitle(" Volunteer");

        RecyclerView  recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


    }
}


