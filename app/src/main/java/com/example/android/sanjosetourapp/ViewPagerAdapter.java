package com.example.android.sanjosetourapp;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jennifernghinguyen on 12/24/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private CharSequence[] pageTitle;

    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context=context;
        pageTitle = context.getResources().getStringArray(R.array.categories);
    }

    @Override
    public Fragment getItem(int position) {
       if(position==0){
           return new RestaurantFragment();
       }else if(position==1){
           return new NightLifeFragment();
       }else if (position==2){
           return new ShoppingFragment();
       }else{
           return new NatureFragment();
       }
    }

    @Override
    public int getCount() {
        return pageTitle.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return pageTitle[0];
        }else if(position==1){
            return pageTitle[1];
        }else if (position==2){
            return pageTitle[2];
        }else{
            return pageTitle[3];
        }
    }
}
