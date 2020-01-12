package com.example.signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Volunteer extends AppCompatActivity {
    RecyclerView mRecyclerView;
    Adapter myAdapter;
    List<Model> myList;
    Model mModel;
    EditText txt_Search;

    private DatabaseReference databaseReference;
    private ValueEventListener eventListener;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);
        getSupportActionBar().setTitle("Volunteer");


        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Volunteer.this, 1);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        txt_Search = (EditText)findViewById(R.id.searchText);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Information...");

        myList = new ArrayList<>();

        myAdapter = new Adapter(Volunteer.this,myList);
        mRecyclerView.setAdapter(myAdapter);

        databaseReference= FirebaseDatabase.getInstance().getReference("NGO");
        progressDialog.show();
        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                myList.clear();
                for(DataSnapshot itemSnapshot: dataSnapshot.getChildren()){
                     mModel = itemSnapshot.getValue(Model.class);

                    myList.add(mModel);
                }
                myAdapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                progressDialog.dismiss();
            }
        });


        txt_Search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());



            }
        });
    }

    private void filter(String text) {

        ArrayList<Model> filterList = new ArrayList<>();
        for (Model item: myList){
            if(item.getTitle().toLowerCase().contains(text.toLowerCase())){

                filterList.add(item);
            }

        }

        myAdapter.filteredList(filterList);
    }


    public void btn_uploadngo(View view) {
        startActivity(new Intent(this,uploadNgoList.class));
    }
}

