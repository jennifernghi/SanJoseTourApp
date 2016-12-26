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

    //private String[] pageTitle = {String.valueOf(R.string.restaurant_category),String.valueOf(R.string.night_life_category),String.valueOf(R.string.shopping_category),String.valueOf(R.string.nature_category)};
    private String[] pageTitle = {"Restaurant","Nightlife","Shopping","Nature"};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
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
            return "Restaurant";
        }else if(position==1){
            return "Nightlife";
        }else if (position==2){
            return "Shopping";
        }else{
            return "Nature";
        }
    }
}
