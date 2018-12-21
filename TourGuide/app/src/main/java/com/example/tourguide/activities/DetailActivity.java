package com.example.tourguide.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tourguide.R;
import com.example.tourguide.models.RestaurantCafe;

public class DetailActivity extends AppCompatActivity {

    public static final String KEY_OBJECT = "keyObject";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // getting the place object.
        RestaurantCafe place = getIntent().getParcelableExtra(KEY_OBJECT);
        //initializing the views.
        TextView titleTv = findViewById(R.id.title_text_view);
        TextView phoneTv = findViewById(R.id.phone_text_view);
        TextView websiteTv = findViewById(R.id.web_text_view);
        TextView addressTv = findViewById(R.id.address_text_view);
        TextView descriptionTv = findViewById(R.id.description_text_view);
        ImageView placeImageView = findViewById(R.id.place_image_view);
        // filling the views.
        titleTv.setText(place.getName());
        phoneTv.setText(place.getPhone());
        websiteTv.setText(place.getWebsite());
        addressTv.setText(place.getAddress());
        descriptionTv.setText(place.getDescription());
        placeImageView.setImageResource(place.getImageResource());
    }

}
