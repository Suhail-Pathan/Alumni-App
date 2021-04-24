package com.example.myphoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class gallery extends AppCompatActivity {
RecyclerView janRecycler,febRecycler;
galleryAdapter adapter;
    List<Integer> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_framgment);

        janRecycler= findViewById(R.id.janRecycler);
        febRecycler=findViewById(R.id.febRecycler);
        
        getjanImage();
        getfebImage();
    }

    private void getfebImage() {
        images = new ArrayList<>();

        images.add(R.drawable.feb1);
        images.add(R.drawable.feb2);
        images.add(R.drawable.feb3);
        images.add(R.drawable.feb4);



        adapter = new galleryAdapter(this,images);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        febRecycler.setLayoutManager(gridLayoutManager);
        febRecycler.setAdapter(adapter);
    }

    private void getjanImage() {
        images = new ArrayList<>();

        images.add(R.drawable.jan1);
        images.add(R.drawable.jan2);
        images.add(R.drawable.jan3);
        images.add(R.drawable.jan4);

        adapter = new galleryAdapter(this,images);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1,GridLayoutManager.HORIZONTAL,false);
        janRecycler.setLayoutManager(gridLayoutManager);
        janRecycler.setAdapter(adapter);

    }
}