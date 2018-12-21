/*------------------------------------------------------------------------------
 - Copyright (c) 2018. This code was created by Younes Charfaoui in the process of Graduation Project for the year of  2018 , which is about creating a platform  for students and professors to help them in the communication and the get known of the university information and so on.
 -----------------------------------------------------------------------------*/

package com.example.tourguide.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tourguide.R;
import com.example.tourguide.models.Place;

import java.util.List;

public class HotelMuseumAdapter extends RecyclerView.Adapter<HotelMuseumAdapter.HotelMuseumHolder> {

    private List<Place> dataList;
    private boolean isHotel;

    public HotelMuseumAdapter(List<Place> dataList, boolean isHotel) {
        this.dataList = dataList;
        this.isHotel = isHotel;
    }

    @NonNull
    @Override
    public HotelMuseumHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.museum_hotel_list_item, parent, false);
        return new HotelMuseumHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelMuseumHolder holder, int position) {
        Place place = dataList.get(position);
        holder.titleTv.setText(place.getName());
        holder.phoneTextView.setText(place.getPhone());
        holder.addressTextView.setText(place.getAddress());
        if (!isHotel) {
            holder.starTextView.setVisibility(View.GONE);
            holder.starIconImageView.setVisibility(View.GONE);
        } else {
            holder.starTextView.setText(place.getDescription());
        }
    }


    @Override
    public int getItemCount() {
        return dataList != null ? dataList.size() : 0;
    }


    class HotelMuseumHolder extends RecyclerView.ViewHolder {

        TextView titleTv, phoneTextView, addressTextView, starTextView;
        ImageView starIconImageView;

        HotelMuseumHolder(View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.title_text_view);
            starTextView = itemView.findViewById(R.id.star_text_view);
            addressTextView = itemView.findViewById(R.id.address_text_view);
            phoneTextView = itemView.findViewById(R.id.phone_text_view);
            starIconImageView = itemView.findViewById(R.id.website_icon);
        }
    }
}
