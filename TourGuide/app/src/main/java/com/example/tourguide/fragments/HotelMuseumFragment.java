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
import com.example.tourguide.adapters.HotelMuseumAdapter;
import com.example.tourguide.models.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * this fragment take care of loading and handling user interface for Hotels and museum list.
 */
public class HotelMuseumFragment extends Fragment {

    private static final int TYPE_MUSEUM = 201;
    private static final int TYPE_HOTEL = 202;
    private static final String KEY_TYPE = "keyType";

    // static method for creating museum fragment.
    public static HotelMuseumFragment museumFragment() {
        Bundle args = new Bundle();
        args.putInt(KEY_TYPE, TYPE_MUSEUM);
        HotelMuseumFragment fragment = new HotelMuseumFragment();
        fragment.setArguments(args);
        return fragment;
    }

    // static method for creating hotel fragment.
    public static HotelMuseumFragment hotelFragment() {
        Bundle args = new Bundle();
        args.putInt(KEY_TYPE, TYPE_HOTEL);
        HotelMuseumFragment fragment = new HotelMuseumFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_places, container, false);
        // getting the type.
        int type = getArguments().getInt(KEY_TYPE, -1);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        // create and empty list.
        List<Place> dataList = new ArrayList<>();
        if (type == TYPE_MUSEUM) {
            dataList.add(new Place(getResources().getStringArray(R.array.museum_one)));
            dataList.add(new Place(getResources().getStringArray(R.array.museum_two)));
            dataList.add(new Place(getResources().getStringArray(R.array.museum_three)));
            dataList.add(new Place(getResources().getStringArray(R.array.museum_four)));
            dataList.add(new Place(getResources().getStringArray(R.array.museum_five)));
            dataList.add(new Place(getResources().getStringArray(R.array.museum_six)));
        } else {
            dataList.add(new Place(getResources().getStringArray(R.array.hotel_one)));
            dataList.add(new Place(getResources().getStringArray(R.array.hotel_two)));
            dataList.add(new Place(getResources().getStringArray(R.array.hotel_three)));
            dataList.add(new Place(getResources().getStringArray(R.array.hotel_four)));
            dataList.add(new Place(getResources().getStringArray(R.array.hotel_five)));
        }
        // creating the adapter.
        HotelMuseumAdapter adapter = new HotelMuseumAdapter(dataList, TYPE_HOTEL == type);
        // setting the recycler view parameters
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        return view;
    }


}
