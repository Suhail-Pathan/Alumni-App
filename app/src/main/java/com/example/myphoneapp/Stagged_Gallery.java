package com.example.myphoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class Stagged_Gallery extends AppCompatActivity {
    private static final String TAG = "Stagged_Gallery";
    private static final int NUM_COLUMNS = 2;

    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stagged__gallery);

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add(R.drawable.feb1);
        mNames.add("Class-Room");

        mImageUrls.add(R.drawable.jan1);
        mNames.add("Kite Fest day");

        mImageUrls.add(R.drawable.feb3);
        mNames.add("Executive Day");

        mImageUrls.add(R.drawable.feb4);
        mNames.add("Tapori Day");


        mImageUrls.add(R.drawable.feb5);
        mNames.add("Traditional Day");

        mImageUrls.add(R.drawable.feb6);
        mNames.add("Red-Dirty Day");


        mImageUrls.add(R.drawable.feb7);
        mNames.add("Red-Dirty Day");

        mImageUrls.add(R.drawable.jan8);
        mNames.add("Kite Fest day");

        mImageUrls.add(R.drawable.jan2);
        mNames.add("Kite Fest day");
        mImageUrls.add(R.drawable.jan4);
        mNames.add("Kite Fest day");
        mImageUrls.add(R.drawable.jan5);
        mNames.add("Kite Fest day");
        mImageUrls.add(R.drawable.jan6);
        mNames.add("Last day of viva");


        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: initializing staggered recyclerview.");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        StaggeredRecyclerViewAdapter staggeredRecyclerViewAdapter =
                new StaggeredRecyclerViewAdapter(this, mNames, mImageUrls);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(staggeredRecyclerViewAdapter);
    }
}







