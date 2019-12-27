package com.example.signup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class modeladapter extends RecyclerView.Adapter<modeladapter.modelviewHolder> {

    Context mContext;
    List<modelclass> itemList;

    public modeladapter(Context mContext, List<modelclass> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @Override
    public modelviewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclercardview,parent,false);

        return new modelviewHolder(v);
    }

    @Override
    public void onBindViewHolder( modelviewHolder holder, int position) {
        holder.title.setText(itemList.get(position).getTitle());
        holder.description.setText(itemList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class modelviewHolder extends RecyclerView.ViewHolder {

        TextView title,description;
        public modelviewHolder(@NonNull View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
        }
    }

}
