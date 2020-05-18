package com.example.aaaaaaaaa2;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private int page;
    ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
    ArrayList<ContentClass> contentClasses;

    public ViewPagerAdapter(Context context, FragmentManager fm, ArrayList<ContentClass> contentClasses1) {
        super(fm);
        this.context = context;
        contentClasses = contentClasses1;
    }

    @Override
    public Fragment getItem(int position) {
        return viewPagerFragment.newInstance(position, contentClasses);
//        return ViewPagerFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return contentClasses.size();
    }
}
