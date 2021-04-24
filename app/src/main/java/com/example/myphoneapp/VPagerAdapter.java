package com.example.myphoneapp;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class VPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList;
    public VPagerAdapter( FragmentManager fm,int behaviour,List<Fragment> fragmentList) {
        super(fm,behaviour);
        this.fragmentList=fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}