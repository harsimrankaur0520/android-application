package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class detailVolunteer extends AppCompatActivity {

    TextView Description;
    ImageView Image;
    Button book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_volunteer);


        Description = (TextView)findViewById(R.id.txtDescription);
        Image= (ImageView)findViewById(R.id.ivImage);
        book = (Button)findViewById(R.id.btnbookSlot);



        Bundle mbundle = getIntent().getExtras();

        if(mbundle!=null){
            Description.setText(mbundle.getString("Description"));
            //Image.setImageResource(mbundle.getInt("Image"));

            Glide.with(this)
                    .load(mbundle.getString("Image"))
            .into(Image);



            book.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(detailVolunteer.this, "You have booked a slot", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
