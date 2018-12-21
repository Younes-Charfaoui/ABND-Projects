package com.example.tourguide.models;

import android.os.Parcel;

/**
 * this object save the information about Restaurant and cafe.
 */
public class RestaurantCafe extends Place {

    // add more fields if we like.
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.imageResource);
    }

    protected RestaurantCafe(Parcel in) {
        super(in);
        this.imageResource = in.readInt();
    }

    public static final Creator<RestaurantCafe> CREATOR = new Creator<RestaurantCafe>() {
        @Override
        public RestaurantCafe createFromParcel(Parcel source) {
            return new RestaurantCafe(source);
        }

        @Override
        public RestaurantCafe[] newArray(int size) {
            return new RestaurantCafe[size];
        }
    };
}
