package com.example.musicalstructure.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.musicalstructure.R;
import com.example.musicalstructure.models.Song;

/**
 * This activity displaying the current music playing.
 */
public class NowPlayingActivity extends AppCompatActivity {

    public static final String KEY_SONG = "keySong";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        Song song = intent.getParcelableExtra(KEY_SONG);
        TextView songNameTv = findViewById(R.id.play_song_name_tv);
        songNameTv.setText(song.getName());
        ImageView songImage = findViewById(R.id.play_song_image);
        songImage.setImageResource(song.getImageResource());
    }

}
