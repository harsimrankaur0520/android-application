package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Volunteer extends AppCompatActivity {
    RecyclerView mRecyclerView;
    Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);
        getSupportActionBar().setTitle("Volunteer");


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new Adapter(this, getmyList());
        mRecyclerView.setAdapter(myAdapter);
    }

    private ArrayList<Model> getmyList() {

        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
        m.setTitle("1st");
        m.setDescription("1st item");
        m.setImg(R.drawable.circle);
        models.add(m);

        m.setTitle("2st");
        m.setDescription("2st item");
        m.setImg(R.drawable.help);
        models.add(m);


        m.setTitle("3st");
        m.setDescription("3st item");
        m.setImg(R.drawable.smile);
        models.add(m);

        m.setTitle("4st");
        m.setDescription("1st item");
        m.setImg(R.drawable.circle);
        models.add(m);


        m.setTitle("5st");
        m.setDescription("1st item");
        m.setImg(R.drawable.help);
        models.add(m);

return models;
    }
}

