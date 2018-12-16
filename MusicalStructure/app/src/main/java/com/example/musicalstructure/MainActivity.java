package com.example.musicalstructure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initializing The ClickListeners.
        findViewById(R.id.album_card).setOnClickListener(this);
        findViewById(R.id.artist_card).setOnClickListener(this);
        findViewById(R.id.genre_card).setOnClickListener(this);
        findViewById(R.id.playlist_card).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.album_card:
                break;
            case R.id.artist_card:
                break;
            case R.id.genre_card:
                break;
            case R.id.playlist_card:
                break;
        }

    }
}
