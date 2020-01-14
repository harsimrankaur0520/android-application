package com.example.signup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


import com.google.android.material.tabs.TabLayout;

public class Requester extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requester);
//        getSupportActionBar().setTitle(" Requester");


        toolbar = (Toolbar) findViewById(R.id.myToolbar);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.myViewPager);

        setSupportActionBar(toolbar);
        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewpagerAdapter_ngo viewPagerAdapter = new ViewpagerAdapter_ngo(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new frag_VolunteerList(), "Volunteer List");
        viewPagerAdapter.addFragment(new frag_service(), "Service");
        viewPager.setAdapter(viewPagerAdapter);
    }
}