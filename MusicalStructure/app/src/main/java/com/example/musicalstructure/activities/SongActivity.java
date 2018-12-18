package com.example.musicalstructure.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.musicalstructure.R;
import com.example.musicalstructure.adapters.SongListener;
import com.example.musicalstructure.adapters.SongsAdapter;
import com.example.musicalstructure.models.Song;

import java.util.List;

/**
 * this activity displays songs in a given album, genre, playlist or
 * artist.
 */
public class SongActivity extends AppCompatActivity implements SongListener {

    public static final String KEY_SONGS = "keySongs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<Song> songs = getIntent().getParcelableArrayListExtra(KEY_SONGS);

        // initializing the recycler view and providing it with incoming data.
        RecyclerView songRecyclerView = findViewById(R.id.songs_recycler_view);
        SongsAdapter adapter = new SongsAdapter(songs, this);
        LinearLayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        songRecyclerView.setAdapter(adapter);
        songRecyclerView.setLayoutManager(manager);
    }

    @Override
    public void onSongClicked(Song song) {
        Intent songIntent = new Intent(this, NowPlayingActivity.class);
        songIntent.putExtra(NowPlayingActivity.KEY_SONG, song);
        startActivity(songIntent);
    }
}
