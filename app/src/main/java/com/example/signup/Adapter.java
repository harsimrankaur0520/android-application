package com.example.signup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Model> modelList;

    public Adapter(Context c, ArrayList<Model> modelList) {
        this.c = c;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.mTitle.setText(modelList.get(position).getTitle());
        holder.mDes.setText(modelList.get(position).getDescription());
        holder.mImageView.setImageResource(modelList.get(position).getImg());


    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
