package com.example.tourguide.models;

public class RestaurantCafe extends Place {

    private int imageResource;

    public RestaurantCafe(String[] data, int imageResource) {
        super(data);
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
