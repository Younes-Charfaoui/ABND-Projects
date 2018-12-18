package com.example.musicalstructure.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.musicalstructure.R;

/**
 * this Activity has the main interface from which the user can go to his music.
 */
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
                goToActivity(MusicActivity.TYPE_ALBUM);
                break;
            case R.id.artist_card:
                goToActivity(MusicActivity.TYPE_ARTIST);
                break;
            case R.id.genre_card:
                goToActivity(MusicActivity.TYPE_GENRE);
                break;
            case R.id.playlist_card:
                goToActivity(MusicActivity.TYPE_PLAYLIST);
                break;
        }
    }

    // method to go to an activity based user choice.
    private void goToActivity(int type) {
        Intent intent = new Intent(this, MusicActivity.class);
        intent.putExtra(MusicActivity.KEY_TYPE, type);
        startActivity(intent);
    }
}
