package com.example.myphoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import java.time.Instant;
import java.util.List;

import static java.lang.System.load;

public class fullimageView extends AppCompatActivity {

    private PhotoView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_fullimage_view);
       imageView=findViewById(R.id.fullimage1);

    String image=getIntent().getStringExtra("image");

        Glide.with(this).load(image).into(imageView);
    }
}