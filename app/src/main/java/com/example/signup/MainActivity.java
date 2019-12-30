package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private  static Button btnvolunteer , btnrequester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(" Status");
        OnClickButtonListener();
    }

    public void OnClickButtonListener(){
        btnvolunteer = (Button)findViewById(R.id.btnvolunteer);
        btnrequester = (Button)findViewById(R.id.btnrequester);
        btnvolunteer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(".Volunteer");
                        //startActivity(intent);
                        startActivity(new Intent(getApplicationContext(),Volunteer.class) );


                    }
                }
        );
        btnrequester.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(".Requester");
                        startActivity(intent);

                    }
                }
        );
    }
}
