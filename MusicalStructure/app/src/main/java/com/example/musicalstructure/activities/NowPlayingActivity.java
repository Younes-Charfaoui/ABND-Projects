package com.example.musicalstructure.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_music_library:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_library, menu);
        return true;
    }
}
