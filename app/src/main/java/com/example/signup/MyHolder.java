package com.example.signup;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView mImageView;
    TextView mTitle, mDes;
    ItemClickListener itemClickListener;

    MyHolder(@NonNull View itemView) {
        super(itemView);

        this.mImageView = itemView.findViewById(R.id.imagetv);
        this.mTitle = itemView.findViewById(R.id.titlTv);
        this.mDes = itemView.findViewById(R.id.descriptionTv);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClickListener(v , getLayoutPosition());
    }

    public void setItemListener(ItemClickListener ic){
    this.itemClickListener = ic;

    }
}
