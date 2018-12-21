package com.example.tourguide.adapters;

import com.example.tourguide.models.RestaurantCafe;

public interface RestaurantCafeListener {

    /**
     * This method is called by the Container of the RestaurantCafeAdapter
     * to handle the click of an item.
     * @param restaurantCafe the object has been clicked
     */
    void onRestaurantCafeItemClicked(RestaurantCafe restaurantCafe);
}
