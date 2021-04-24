package com.example.myphoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import android.os.Bundle;

import com.example.myphoneapp.pagerfragment.pagerfragment1;
import com.example.myphoneapp.pagerfragment.pagerfragment2;
import com.example.myphoneapp.pagerfragment.pagerfragment3;

import java.util.ArrayList;
import java.util.List;

public class home_page extends AppCompatActivity {
    private VirticalviewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        List<Fragment> list=new ArrayList<>();
        list.add(new pagerfragment1());
        list.add(new pagerfragment2());
        list.add(new pagerfragment3());

        viewPager=findViewById(R.id.pager);
        pagerAdapter=new VPagerAdapter(getSupportFragmentManager(),0,list);
        viewPager.setAdapter(pagerAdapter);
    }
}