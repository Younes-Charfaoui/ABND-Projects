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

/**
 * this adapter take care of loading and displaying data in lost for a recycler view for restaurant and cafe.
 */
public class RestaurantCafeAdapter extends RecyclerView.Adapter<RestaurantCafeAdapter.RestaurantCafeHolder> {

    private List<RestaurantCafe> dataList;
    private RestaurantCafeListener listener;

    public RestaurantCafeAdapter(List<RestaurantCafe> dataList, RestaurantCafeListener listener) {
        this.dataList = dataList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RestaurantCafeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.place_list_item, parent, false);
        return new RestaurantCafeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantCafeHolder holder, int position) {
        RestaurantCafe place = dataList.get(position);
        holder.titleTv.setText(place.getName());
        holder.placeImageView.setImageResource(place.getImageResource());
    }

    @Override
    public int getItemCount() {
        return dataList != null ? dataList.size() : 0;
    }

    class RestaurantCafeHolder extends RecyclerView.ViewHolder {

        TextView titleTv;
        ImageView placeImageView;

        RestaurantCafeHolder(View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.title_text_view);
            placeImageView = itemView.findViewById(R.id.place_image_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onRestaurantCafeItemClicked(dataList.get(getAdapterPosition()));
                }
            });
        }
    }
}
