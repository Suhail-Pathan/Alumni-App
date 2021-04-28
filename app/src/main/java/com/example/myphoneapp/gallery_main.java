package com.example.myphoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class gallery_main extends AppCompatActivity {
    RecyclerView recyclerView;
    adapter adapter;
    private List<String> title;
   List<Integer> images;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //Will Hide the Title
        getSupportActionBar().hide(); //Hide the Title Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //Enable Full Screen

        setContentView(R.layout.activity_gallery_main);

        title = new ArrayList<>();
         images = new ArrayList<>();
        title.add("A");
        title.add("B");
        title.add("C");
        title.add("D");
        images.add(R.drawable.feb1);
        images.add(R.drawable.feb5);
        images.add(R.drawable.feb3);
        images.add(R.drawable.feb4);



        recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new adapter(this,title,images);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false);

       recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

    }
}
