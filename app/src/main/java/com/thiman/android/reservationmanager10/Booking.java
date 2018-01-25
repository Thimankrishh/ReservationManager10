package com.thiman.android.reservationmanager10;

import android.nfc.Tag;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class Booking extends AppCompatActivity {

    ArrayList<String> roomId;
    ArrayList<String> checkinDate;
    ArrayList<String> checkoutDate;
    RecyclerView roomRecycler;
    ViewPager viewPagerBooking;
    RecyclerView.LayoutManager roomLayoutManager;
    MainAdapter roomAdapter;
    PagerAdapter pagerAdapterBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


//        viewPagerBooking = (ViewPager) findViewById(R.id.viewpager);
        roomRecycler = (RecyclerView)findViewById(R.id.rv_recycler_view);

        roomId = new ArrayList<>();
        checkinDate = new ArrayList<>();
        checkoutDate = new ArrayList<>();

        for(int i = 0; i<=10;i++) {
            roomId.add("i"+i);
            checkinDate.add("01.22");
            checkoutDate.add("01.26");

        }
        roomRecycler.setHasFixedSize(true);
        roomLayoutManager = new LinearLayoutManager(this);
        roomAdapter = new MainAdapter(roomId,checkinDate,checkoutDate);
        roomRecycler.setLayoutManager(roomLayoutManager);
        roomRecycler.setAdapter(roomAdapter);





    }
}
