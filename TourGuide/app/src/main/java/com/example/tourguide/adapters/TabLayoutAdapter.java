/*------------------------------------------------------------------------------
 - Copyright (c) 2018. This code was created by Younes Charfaoui in the process of Graduation Project for the year of  2018 , which is about creating a platform  for students and professors to help them in the communication and the get known of the university information and so on.
 -----------------------------------------------------------------------------*/

package com.example.tourguide.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class TabLayoutAdapter extends FragmentPagerAdapter {

    private int mNumbersOfTabs;


    public TabLayoutAdapter(FragmentManager fm, int numbersOfTab) {
        super(fm);
        this.mNumbersOfTabs = numbersOfTab;
    }

    @Override
    public Fragment getItem(int position) {

        switch (mNumbersOfTabs) {
            case 3:
                switch (position) {
                    case 0:

                    case 1:

                    case 2:

                    default:
                        return null;
                }
            case 2:
                switch (position) {
                    case 0:

                    case 1:

                    default:
                        return null;
                }
            default:
                return null;
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
