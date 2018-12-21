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
import com.example.tourguide.models.RestaurantCafe;

import java.util.List;

public class RestaurantCafeAdapter extends RecyclerView.Adapter<RestaurantCafeAdapter.MailViewHolder> {

    private List<RestaurantCafe> dataList;

    public RestaurantCafeAdapter(List<RestaurantCafe> dataList) {
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public MailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.place_list_item, parent, false);
        return new MailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MailViewHolder holder, int position) {
        RestaurantCafe place = dataList.get(position);
        holder.titleTv.setText(place.getName());
        holder.placeImageView.setImageResource(place.getImageResource());
    }


    @Override
    public int getItemCount() {
        return dataList != null ? dataList.size() : 0;
    }


    class MailViewHolder extends RecyclerView.ViewHolder {

        TextView titleTv;
        ImageView placeImageView;

        MailViewHolder(View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.title_text_view);
            placeImageView = itemView.findViewById(R.id.place_image_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
