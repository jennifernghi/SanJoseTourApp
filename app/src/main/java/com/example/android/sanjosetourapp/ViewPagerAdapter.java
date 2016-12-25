package com.example.android.sanjosetourapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jennifernghinguyen on 12/24/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private String[] pageTitle = {String.valueOf(R.string.restaurant_category),String.valueOf(R.string.night_life_category),String.valueOf(R.string.shopping_category),String.valueOf(R.string.nature_category)};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
