package com.thiman.android.reservationmanager10;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;

public class AvailableRooms extends AppCompatActivity {


    ArrayList<String> roomIdAr;
    ArrayList<String> roomType;
    ArrayList<String> packageType;
    RecyclerView roomRecyclerAr;
    ViewPager viewPagerBooking;
    RecyclerView.LayoutManager roomLayoutManagerAr;
    AvailableRoomsAdapter roomAdapterAr;
    PagerAdapter pagerAdapterBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_rooms);
        Log.i("Tag :", "onCreateActivity");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarAr);
        //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.i("Tag :", "toolbar");
        }
        Log.i("Tag :", "out");
        roomRecyclerAr = (RecyclerView) findViewById(R.id.rv_recycler_view_ar);

        roomIdAr = new ArrayList<>();
        roomType = new ArrayList<>();
        packageType = new ArrayList<>();

        for (int i = 0; i <= 15; i++) {
            roomIdAr.add("j" + i);
            roomType.add("01.20");
            packageType.add("01.26");

        }

        Log.i("Tag :", "out");
        roomRecyclerAr.setHasFixedSize(true);
        roomLayoutManagerAr = new LinearLayoutManager(this);
        Log.i("Tag :", "B4");
        roomAdapterAr = new AvailableRoomsAdapter(roomIdAr, roomType, packageType);
        Log.i("Tag :", "Adapter");
        roomRecyclerAr.setLayoutManager(roomLayoutManagerAr);
        roomRecyclerAr.setAdapter(roomAdapterAr);
    }

}