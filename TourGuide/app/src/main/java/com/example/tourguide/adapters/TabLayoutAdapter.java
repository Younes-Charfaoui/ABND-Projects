package com.example.tourguide.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.tourguide.fragments.HotelMuseumFragment;
import com.example.tourguide.fragments.RestaurantCafeFragment;

/**
 * this Adapter take care of handling viewpager needs about fragment in tabs.
 */
public class TabLayoutAdapter extends FragmentPagerAdapter {

    private final int mNumbersOfTabs;

    public TabLayoutAdapter(FragmentManager fm, int numbersOfTab) {
        super(fm);
        this.mNumbersOfTabs = numbersOfTab;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return HotelMuseumFragment.hotelFragment();
            case 1:
                return RestaurantCafeFragment.cafeFragment();
            case 2:
                return RestaurantCafeFragment.restaurantFragment();
            case 3:
                return HotelMuseumFragment.museumFragment();
            default:
                return HotelMuseumFragment.museumFragment();
        }
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
