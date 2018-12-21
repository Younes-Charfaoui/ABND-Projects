/*------------------------------------------------------------------------------
 - Copyright (c) 2018. This code was created by Younes Charfaoui in the process of Graduation Project for the year of  2018 , which is about creating a platform  for students and professors to help them in the communication and the get known of the university information and so on.
 -----------------------------------------------------------------------------*/

package com.example.tourguide.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tourguide.R;
import com.example.tourguide.adapters.RestaurantCafeAdapter;
import com.example.tourguide.models.RestaurantCafe;

import java.util.ArrayList;
import java.util.List;


public class RestaurantCafeFragment extends Fragment {

    private static final int TYPE_RESTAURANT = 101;
    private static final int TYPE_CAFE = 102;
    private static final String KEY_TYPE = "keyType";

    public static RestaurantCafeFragment restaurantFragment() {
        Bundle args = new Bundle();
        args.putInt(KEY_TYPE , TYPE_RESTAURANT);
        RestaurantCafeFragment fragment = new RestaurantCafeFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_places, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        List<RestaurantCafe> dataList = new ArrayList<>();
        dataList.add(new RestaurantCafe(getResources().getStringArray(R.array.cafe_one), R.drawable.cafe_1));
        dataList.add(new RestaurantCafe(getResources().getStringArray(R.array.cafe_two), R.drawable.cafe_2));
        dataList.add(new RestaurantCafe(getResources().getStringArray(R.array.cafe_three), R.drawable.cafe_3));
        dataList.add(new RestaurantCafe(getResources().getStringArray(R.array.cafe_four), R.drawable.cafe_4));
        dataList.add(new RestaurantCafe(getResources().getStringArray(R.array.cafe_five), R.drawable.cafe_5));


        RestaurantCafeAdapter adapter = new RestaurantCafeAdapter(dataList);

        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        return view;
    }


}
