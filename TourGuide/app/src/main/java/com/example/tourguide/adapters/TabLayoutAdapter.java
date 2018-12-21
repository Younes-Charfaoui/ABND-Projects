/*------------------------------------------------------------------------------
 - Copyright (c) 2018. This code was created by Younes Charfaoui in the process of Graduation Project for the year of  2018 , which is about creating a platform  for students and professors to help them in the communication and the get known of the university information and so on.
 -----------------------------------------------------------------------------*/

package com.example.tourguide.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.tourguide.fragments.RestaurantCafeFragment;


public class TabLayoutAdapter extends FragmentPagerAdapter {

    private int mNumbersOfTabs;


    public TabLayoutAdapter(FragmentManager fm, int numbersOfTab) {
        super(fm);
        this.mNumbersOfTabs = numbersOfTab;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return RestaurantCafeFragment.cafeFragment();
            case 1:
                return RestaurantCafeFragment.restaurantFragment();
            case 2:
                return RestaurantCafeFragment.restaurantFragment();
            case 3:
                return RestaurantCafeFragment.restaurantFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mNumbersOfTabs;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }
}
