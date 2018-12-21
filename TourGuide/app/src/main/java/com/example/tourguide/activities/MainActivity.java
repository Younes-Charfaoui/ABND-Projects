package com.example.tourguide.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.tourguide.R;
import com.example.tourguide.adapters.RestaurantCafeListener;
import com.example.tourguide.adapters.TabLayoutAdapter;
import com.example.tourguide.models.RestaurantCafe;

/**
 * the main activity takes care of adding the view pager and the tab layout, also receive user interaction.
 */
public class MainActivity extends AppCompatActivity implements RestaurantCafeListener {

    private ViewPager mMainViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // initializing the views.
        mMainViewPager = findViewById(R.id.main_view_pager);
        mTabLayout = findViewById(R.id.main_tab_layout);
        // initializing the views and the adapters.
        setupViewPagerAndTabLayout();
    }

    /**
     * this Method is a helper Method for initializing the
     * view pager and the tab layout.
     */
    private void setupViewPagerAndTabLayout() {
        setupTabIcons();
        TabLayoutAdapter adapter = new TabLayoutAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mMainViewPager.setAdapter(adapter);
        mMainViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mMainViewPager.setCurrentItem(tab.getPosition());
                AppBarLayout appBarLayout = findViewById(R.id.appbar);
                appBarLayout.setExpanded(true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /**
     * this addMethod is a helper addMethod for initializing the
     * tabs that in the tab layout.
     */
    private void setupTabIcons() {
        if (mTabLayout.getTabCount() > 0) {
            mTabLayout.removeAllTabs();
        }
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.ic_hotel));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.ic_cafe));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.ic_restaurant));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.ic_museum));
    }

    @Override
    public void onRestaurantCafeItemClicked(RestaurantCafe restaurantCafe) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.KEY_OBJECT, restaurantCafe);
        startActivity(intent);
    }
}
